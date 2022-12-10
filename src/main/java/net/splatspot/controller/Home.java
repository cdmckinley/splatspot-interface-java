package net.splatspot.controller;

import net.splatspot.utilities.ServletUtilities;
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
     * @param res The HttpServletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        String logout = req.getParameter("logout");

        if (logout != null) {
            HttpSession session = req.getSession();
            session.invalidate();
            ServletUtilities.redirectToPage(req, res, "/home", "/home");
            return;
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/home.jsp");
        dispatcher.forward(req, res);
    }
}
