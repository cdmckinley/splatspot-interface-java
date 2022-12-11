package net.splatspot.controller;

import net.splatspot.entity.SharedMedia;
import net.splatspot.entity.User;
import net.splatspot.persistence.Dao;
import net.splatspot.persistence.YouTubeAccess;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * The servlet for listing existing SharedMedia entities and relevant data.
 */
@WebServlet(
        urlPatterns = {"/list-videos"}
)
public class ListVideos extends HttpServlet {

    /**
     * The Logger
     */
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * The User DAO
     */
    private Dao<User> userDao = new Dao<>(User.class);

    /**
     * The SharedMedia DAO
     */
    private Dao<SharedMedia> sharedMediaDao = new Dao<>(SharedMedia.class);

    /**
     * Loads SharedMedia entities and relevant data, then forward to the JSP.
     * @param req The Http Servlet Request
     * @param res The Http Servlet Response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String searchInput = req.getParameter("user");
        List<SharedMedia> videoList;

        if (searchInput == null || searchInput.isBlank()) {
            videoList = sharedMediaDao.getAll();
        } else {
            List<User> userList = userDao.getByProperty("username", searchInput);
            if (userList.size() == 0) {
                res.sendError(404);
                return;
            }
            videoList = new ArrayList<>(userList.get(0).getSharedMediaSet());
        }

        YouTubeAccess youTubeAccess = new YouTubeAccess();
        for (SharedMedia video : videoList) {
            video.setSnippet(youTubeAccess);
        }

        req.setAttribute("videos", videoList);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/list-videos.jsp");
        dispatcher.forward(req, res);
    }
}
