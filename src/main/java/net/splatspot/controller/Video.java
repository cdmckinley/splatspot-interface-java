package net.splatspot.controller;

import net.splatspot.entity.SharedMedia;
import net.splatspot.entity.User;
import net.splatspot.persistence.Dao;
import net.splatspot.persistence.YouTubeAccess;
import net.splatspot.utilities.ServletUtilities;
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

    private YouTubeAccess youTubeAccess = new YouTubeAccess();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String id = req.getParameter("video-id");
        HttpSession session = req.getSession();

        if (id == null) {
            session.setAttribute("videoToEdit", 0);
        } else {
            int idNumber = ServletUtilities.getSharedMediaIdFromQuery(res, id);
            if (idNumber < 0) return;

            SharedMedia video = ServletUtilities.getVideoFromId(res, sharedMediaDao, idNumber);
            if (ServletUtilities.sharedMediaIsSentinel(video)) return;


            String username = (String) session.getAttribute("userName");
            if (username == null || !username.equals(video.getUser().getUsername())) {
                res.sendError(401);
                return;
            }
            session.setAttribute("videoToEdit", idNumber);
            video.setSnippet(youTubeAccess);
            req.setAttribute("videoName", video.getSnippet().getTitle());
            req.setAttribute("mode", "edit");
        }

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

        int videoIdNumber = (int) session.getAttribute("videoToEdit");

        String description = req.getParameter("description");
        String link = req.getParameter("link");

        SharedMedia video = null;
        if (videoIdNumber > 0) {
            video = ServletUtilities.getVideoFromId(res, sharedMediaDao, videoIdNumber);
            if (ServletUtilities.sharedMediaIsSentinel(video)) return;
        } else if (link == null || link.length() != 11) {
            res.sendError(400);
            return;
        }

        if (description == null || description.length() > 500) {
            res.sendError(400);
            return;
        }

        boolean videoIsNew;

        if (video == null) {
            video = new SharedMedia();
            video.setLink(link);
            video.setUser(user);
            user.addSharedMedia(video);
            videoIsNew = true;
        } else {
            videoIsNew = false;
        }
        video.setDescription(description);

        if (videoIsNew) {
            int id = sharedMediaDao.insert(video);
            logger.debug("Inserted a video of ID " + id + " into the database");
        } else {
            sharedMediaDao.update(video);
            logger.debug("Updated video of ID " + video.getId());
        }
        ServletUtilities.redirectToPage(req, res, "/video", "/list-videos");
    }
}
