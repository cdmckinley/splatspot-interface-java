package net.splatspot.utilities;

import net.splatspot.entity.SharedMedia;
import net.splatspot.persistence.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Static methods for use in Servlets
 */
public class ServletUtilities {

    /**
     * Gets video from id.
     *
     * @param res            the Http Servlet Response
     * @param sharedMediaDao the shared media dao
     * @param idNumber       the id number for the SharedMedia entity
     * @return the SharedMedia entity
     * @throws IOException
     */
    public static SharedMedia getVideoFromId(HttpServletResponse res, Dao<SharedMedia> sharedMediaDao, int idNumber)
            throws IOException {
        SharedMedia video = sharedMediaDao.getById(idNumber);

        if (video == null) {
            res.sendError(404);
            return sharedMediaSentinel();
        }

        return video;
    }

    /**
     * Gets shared media id number from String.
     *
     * @param res the Http Servlet Response
     * @param id  the id number (formatted as String) for the SharedMedia entity
     * @return the shared media id number
     * @throws IOException the io exception
     */
    public static int getSharedMediaIdFromQuery(HttpServletResponse res, String id) throws IOException{
        if (id == null || id.isBlank()) {
            res.sendError(400);
            return -1;
        }

        int idNumber;
        try {
            idNumber = Integer.parseInt(id);
        } catch (NumberFormatException nfe) {
            res.sendError(400);
            return -1;
        }
        return idNumber;
    }

    /**
     * Returns a blank SharedMedia instance, telling the program not to proceed.
     *
     * @return a blank SharedMedia
     */
    public static SharedMedia sharedMediaSentinel() {
        return new SharedMedia();
    }

    /**
     * Checks if a SharedMedia is a sentinel (blank).
     *
     * @param sharedMedia the shared media
     * @return true if the SharedMedia is a sentinel (blank)
     */
    public static boolean sharedMediaIsSentinel(SharedMedia sharedMedia) {
        if (sharedMedia.getId() <= 0) return true;
        return false;
    }

    /**
     * Redirect to another page.
     *
     * @param req     the Http Servlet Request
     * @param resp    the Http Servlet Response
     * @param oldPage the page to redirect from
     * @param newPage the page to redirect to
     * @throws IOException
     */
    public static void redirectToPage(HttpServletRequest req, HttpServletResponse resp, String oldPage, String newPage)
            throws IOException{
        String urlParam = oldPage;
        String url = req.getRequestURL().toString();
        url = url.substring(0, url.length() - urlParam.length());
        url = url + newPage;
        resp.sendRedirect(url);
    }
}
