package net.splatspot.utilities;

import net.splatspot.entity.SharedMedia;
import net.splatspot.persistence.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletUtilities {

    public static SharedMedia getVideoFromId(HttpServletResponse res, Dao<SharedMedia> sharedMediaDao, int idNumber)
            throws IOException {
        SharedMedia video = sharedMediaDao.getById(idNumber);

        if (video == null) {
            res.sendError(404);
            return sharedMediaSentinel();
        }

        return video;
    }

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

    public static SharedMedia sharedMediaSentinel() {
        return new SharedMedia();
    }

    public static boolean sharedMediaIsSentinel(SharedMedia sharedMedia) {
        if (sharedMedia.getId() <= 0) return true;
        return false;
    }

    public static void redirectToPage(HttpServletRequest req, HttpServletResponse resp, String oldPage, String newPage)
            throws IOException{
        String urlParam = oldPage;
        String url = req.getRequestURL().toString();
        url = url.substring(0, url.length() - urlParam.length());
        url = url + newPage;
        resp.sendRedirect(url);
    }
}
