package net.splatspot.controller;

import net.splatspot.entity.User;
import net.splatspot.persistence.Dao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

@WebServlet(
        urlPatterns = {"/profile"}
)
public class Profile extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());
    private Dao<User> userDao = new Dao<>(User.class);


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        if (session != null && verifyUserExists(session, req)) {
            User user = loadUser(req.getAttribute("userName").toString());
            setAttributeIgnoringNull(req, "splashTagName", user.getSplashTagName());
            setAttributeIgnoringNull(req, "splashTagNumber", user.getSplashTagNumber());
            setAttributeIgnoringNull(req, "nickname", user.getNickname());
            setAttributeIgnoringNull(req, "friendCode", user.getFriendCode());
            setAttributeIgnoringNull(req, "shareInfo", toPlainEnglish(user.getShareInfoWithUsers()));
            setAttributeIgnoringNull(req, "shareStatus", toPlainEnglish(user.getShareWhenReadyToPlay()));

            RequestDispatcher dispatcher = req.getRequestDispatcher("/profile.jsp");
            dispatcher.forward(req, resp);
        } else {
            logger.debug("No username was found");
            // TODO make a common method for this:
            String urlParam = "/profile";
            String url = req.getRequestURL().toString();
            url = url.substring(0, url.length() - urlParam.length());
            url = url + "/home";
            resp.sendRedirect(url);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        Object userNameAttribute = session.getAttribute("userName");

        if (!Objects.isNull(userNameAttribute)) {
            String userName = userNameAttribute.toString();
            User user = loadUser(userName);

            // TODO write a method like these parts of the code
            String nickname = req.getParameter("nickname");
            if (nickname.isBlank()) {
                if (!nickname.isEmpty()) {
                    user.setNickname(null);
                }
                // Else, don't make any changes to the nickname
            } else {
                // TODO verify data
                user.setNickname(nickname);
            }

            String friendCode = req.getParameter("friend-code");
            if (friendCode.isBlank()) {
                if (!friendCode.isEmpty()) {
                    user.setFriendCode(null);
                }
            } else {
                // TODO verify friend code is a friend code (format: SW-****-****-****)
                user.setFriendCode(friendCode);
            }

            String splashTagName = req.getParameter("splash-tag-name");
            String splashTagNumber = req.getParameter("splash-tag-number");
            if (splashTagName.isBlank() || splashTagNumber.isBlank()) {
                if (splashTagName.isBlank() && !splashTagName.isEmpty() && splashTagNumber.isBlank() &&
                        !splashTagNumber.isEmpty()) {
                    user.setSplashTagName(null);
                    user.setSplashTagNumber(null);
                } else {
                    logger.warn("User submitted an invalid Splash Tag");
                }
            } else {
                // TODO verify Splash Tag is valid, or submit neither part
                user.setSplashTagName(splashTagName);
                user.setSplashTagNumber(splashTagNumber);
            }

            String shareInfo = req.getParameter("share-info");
            // TODO write a method for checking keep/yes/no
            switch (shareInfo) {
                case "no": user.setShareInfoWithUsers(false); break;
                case "yes": user.setShareInfoWithUsers(true); break;
                default: break;
            }

            String shareStatus = req.getParameter("share-status");
            switch (shareStatus) {
                case "no": user.setShareWhenReadyToPlay(false); break;
                case "yes": user.setShareWhenReadyToPlay(true); break;
                default: break;
            }

            userDao.update(user);

        } else {
            logger.debug("No user was found");
        }
        // Redirect to a GET request
        String url = req.getRequestURL().toString();
        resp.sendRedirect(url);
    }

    protected User loadUser(String username) {
        List<User> users = userDao.getByProperty("username", username);
        if (users.size() == 1)
        return users.get(0);
        else return null;
    }

    protected String toPlainEnglish(boolean choice) {
        if (choice) return "Yes";
        else return "No";
    }

    protected void setAttributeIgnoringNull(HttpServletRequest req, String attributeName, String value) {
        if (!Objects.isNull(value)) {
            req.setAttribute(attributeName, value);
        }
    }

    protected boolean verifyUserExists(HttpSession session, HttpServletRequest req) {
        if (!Objects.isNull(session.getAttribute("userName"))) {
            String userName = session.getAttribute("userName").toString();
            req.setAttribute("userName", userName);
            return true;
        } else return false;
    }
}
