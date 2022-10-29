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

@WebServlet(
        urlPatterns = {"/profile"}
)
public class Profile extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        try {
            String userName = session.getAttribute("userName").toString();
            req.setAttribute("userName",userName);
            User user = loadUser(userName);
            req.setAttribute("splashTag", user.readSplashTag());
            req.setAttribute("nickname", user.getNickname());
            req.setAttribute("friendCode", user.getFriendCode());
            // TODO set attributes for more data
            RequestDispatcher dispatcher = req.getRequestDispatcher("/profile.jsp");
            dispatcher.forward(req, resp);
        } catch (NullPointerException npe) {
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
        HttpSession session = req.getSession(false);
        String userName;

        try {
            userName = session.getAttribute("userName").toString();
            User user = loadUser(userName);
            // TODO set new user properties and update the

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
        } catch (NullPointerException npe) {
            logger.debug("No user was found");
        } finally {
            // Redirect to a GET request
            String url = req.getRequestURL().toString();
            resp.sendRedirect(url);
        }
    }

    protected User loadUser(String username) {
        Dao<User> userDao = new Dao<>(User.class);
        List<User> users = userDao.getByProperty("username", username);
        if (users.size() == 1)
        return users.get(0);
        else return null;
    }
}
