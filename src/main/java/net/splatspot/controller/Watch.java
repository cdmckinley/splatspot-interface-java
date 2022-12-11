package net.splatspot.controller;

import com.google.api.services.youtube.model.VideoSnippet;
import net.splatspot.entity.SharedMedia;
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
import java.io.IOException;

@WebServlet(
        urlPatterns = {"/watch"}
)
public class Watch extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    private Dao<SharedMedia> sharedMediaDao = new Dao<>(SharedMedia.class);
    private YouTubeAccess youtubeAccess = new YouTubeAccess();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String id = req.getParameter("video-id");

        int idNumber = ServletUtilities.getSharedMediaIdFromQuery(res, id);
        if (idNumber < 0) return;

        SharedMedia video = ServletUtilities.getVideoFromId(res, sharedMediaDao, idNumber);
        if (ServletUtilities.sharedMediaIsSentinel(video)) return;

        req.setAttribute("id", idNumber);

        String videoLink = video.getLink();

        req.setAttribute("videoId", videoLink);
        req.setAttribute("profileName", video.getUser().getUsername());
        String description = video.getDescription();

        if (description == null) description = "";
        req.setAttribute("mediaDescription", description);

        try {
            video.setSnippet(youtubeAccess);
        } catch (IOException ioe) {
            logger.error(ioe.getStackTrace());
        }
        VideoSnippet snippet = video.getSnippet();

        if (snippet == null) {
            logger.warn("The link from the database does not reach a valid video: " + videoLink);
            res.sendError(502);
            return;
        }

        req.setAttribute("snippet", snippet);

        RequestDispatcher dispatcher = req.getRequestDispatcher("watch.jsp");
        dispatcher.forward(req, res);
    }
}
