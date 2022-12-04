package net.splatspot.controller;

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
import java.util.Objects;

/**
 * The controller for the home page.
 */
@WebServlet(
        urlPatterns = {"/home"}
)
public class Home extends HttpServlet {

    /**
     * The Logger
     */
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Forward to the 'home' jsp when a GET request is received
     * @param req The HttpServletRequest
     * @param resp The HttpServletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Object userNameAttribute = session.getAttribute("userName");
        if (!Objects.isNull(userNameAttribute)) {
            String userName = userNameAttribute.toString();
            req.setAttribute("userName", userName);
        } else {
            logger.debug("No username was found");
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("/home.jsp");
        dispatcher.forward(req, resp);
    }
}
