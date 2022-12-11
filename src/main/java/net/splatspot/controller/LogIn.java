package net.splatspot.controller;

import edu.matc.utilities.PropertiesLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Properties;

/**
 * Begins the authentication process using AWS Cognito.
 */
@WebServlet(
        urlPatterns = {"/login"}
)
public class LogIn extends HttpServlet implements PropertiesLoader {
    /**
     * The Cognito properties.
     */
    Properties properties;

    /**
     * The Logger.
     */
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * The Cognito Client ID.
     */
    public static String CLIENT_ID;

    /**
     * The Cognito Login URL.
     */
    public static String LOGIN_URL;

    /**
     * The Cognito Redirect URL.
     */
    public static String REDIRECT_URL;

    /**
     * Loads properties for Cognito.
     * @throws ServletException
     */
    @Override
    public void init() throws ServletException {
        super.init();
        try {
            properties = loadProperties("/cognito.properties");
            CLIENT_ID = properties.getProperty("client.id");
            LOGIN_URL = properties.getProperty("loginURL");
            REDIRECT_URL = properties.getProperty("redirectURL");
        } catch (Exception exception) {
            logger.error("An " + exception.getClass().getName() +
                            " occurred. Make sure a properly formatted 'cognito.properties' file exists and is readable",
                    exception);
            properties = null;
        }
    }

    /**
     * Route to the aws-hosted cognito login page. Respond with 500 error if properties didn't properly load.
     * @param req servlet request
     * @param resp servlet response
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        if (properties == null) {
            resp.sendError(500);
            return;
        }

        String url = LOGIN_URL + "?response_type=code&client_id=" + CLIENT_ID + "&redirect_uri=" + REDIRECT_URL;
        resp.sendRedirect(url);
    }
}
