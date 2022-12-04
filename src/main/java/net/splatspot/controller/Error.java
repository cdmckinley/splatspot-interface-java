package net.splatspot.controller;

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
import java.util.Objects;

/**
 * The controller for the Error page.
 */
@WebServlet(
        urlPatterns = {"/error"}
)
public class Error extends HttpServlet {

    /**
     * The Logger
     */
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Forwards to the 'error' JSP when there's a GET request.
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
        String errorType = req.getParameter("type");
        if (errorType.equals("not-found") || errorType.equals("server")) {
            req.setAttribute("errorType", errorType);
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("/error.jsp");
        dispatcher.forward(req, resp);
    }
}
