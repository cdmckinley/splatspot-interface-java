package net.splatspot.controller;

import net.splatspot.entity.SharedMedia;
import net.splatspot.persistence.Dao;
import net.splatspot.utilities.ServletUtilities;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * The Delete servlet.
 */
@WebServlet(
        urlPatterns = {"/delete"}
)
public class Delete extends HttpServlet {

    /**
     * The SharedMedia DAO
     */
    private Dao<SharedMedia> sharedMediaDao = new Dao<>(SharedMedia.class);

    /**
     * Determines data for the delete JSP and forwards there. Responds with a 401 error if unauthorized.
     * @param req The Http Servlet Request
     * @param res The Http Servlet Response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String id = req.getParameter("video-id");

        int idNumber = ServletUtilities.getSharedMediaIdFromQuery(res, id);
        if (idNumber < 0) return;

        SharedMedia video = ServletUtilities.getVideoFromId(res, sharedMediaDao, idNumber);
        if (ServletUtilities.sharedMediaIsSentinel(video)) return;

        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("userName");
        if (username == null || !username.equals(video.getUser().getUsername())) {
            res.sendError(401);
            return;
        }

        session.setAttribute("video-to-delete", idNumber);

        RequestDispatcher dispatcher = req.getRequestDispatcher("delete.jsp");
        dispatcher.forward(req, res);
    }

    /**
     * Deletes a SharedMedia entity.
     * @param req The Http Servlet Request
     * @param res The HttpServlet Response
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String shouldDelete = req.getParameter("yes");
        if (shouldDelete != null && !shouldDelete.isBlank()) {
            HttpSession session = req.getSession();

            int idNumber = (int) session.getAttribute("video-to-delete");

            sharedMediaDao.delete(sharedMediaDao.getById(idNumber));
        }
        ServletUtilities.redirectToPage(req, res, "/delete", "/list-videos");
    }
}
