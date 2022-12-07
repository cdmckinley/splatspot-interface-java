package net.splatspot.controller;

import net.splatspot.entity.SharedMedia;
import net.splatspot.entity.User;
import net.splatspot.persistence.Dao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(
        urlPatterns = {"/video"}
)
public class Video extends HttpServlet {

    /**
     * The Logger
     */
    private final Logger logger = LogManager.getLogger(this.getClass());

    private Dao<User> userDao = new Dao<>(User.class);
    private Dao<SharedMedia> sharedMediaDao = new Dao<>(SharedMedia.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("video.jsp");
        dispatcher.forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("userName");

        List<User> userList = userDao.getByProperty("username", username);

        if (userList == null || userList.isEmpty()) {
            res.sendError(401);
            return;
        }
        User user = userList.get(0);

        String link = req.getParameter("link");
        String description = req.getParameter("description");

        if (link == null || link.length() != 11 || description == null || description.length() > 500) {
            res.sendError(400);
            return;
        }

        SharedMedia video = new SharedMedia();
        video.setLink(link);
        video.setDescription(description);

        video.setUser(user);
        user.addSharedMedia(video);

        int id = sharedMediaDao.insert(video);

        logger.debug("Inserted a video of ID " + id + " into the database");

        redirectToPage(req, res, "/list-videos");
    }

    protected void redirectToPage(HttpServletRequest req, HttpServletResponse res, String pageName) throws IOException{
        String urlParam = "/video";
        String url = req.getRequestURL().toString();
        url = url.substring(0, url.length() - urlParam.length());
        url = url + pageName;
        res.sendRedirect(url);
    }
}
