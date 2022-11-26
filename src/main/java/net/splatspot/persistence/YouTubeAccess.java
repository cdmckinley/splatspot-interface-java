package net.splatspot.persistence;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.
import edu.matc.utilities.PropertiesLoader;

import com.google.api.services.youtube.YouTube;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Properties;

/**
 * A class for accessing data from YouTube.
 * Based in part on Java example from https://developers.google.com/youtube/v3/code_samples/code_snippets?apix=true
 */
public class YouTubeAccess implements PropertiesLoader {

    private final Logger logger = LogManager.getLogger(this.getClass());
    private Properties properties;

    private static final String CLIENT_SECRET_FILE_NAME = "client_secret.json";
    private static final Collection<String> SCOPES = Arrays.asList("https://www.googleapis.com/auth/youtube.readonly");

    private static final JsonFactory JSON_FACTORY; // TODO Add default instance of JacksonFactory from jackson2?

    private static String APPLICATION_NAME;
    private YouTube youtubeservice;


    public YouTubeAccess() {
        try {
            properties = loadProperties("/youtube.properties");
            APPLICATION_NAME = properties.getProperty("application_name");
        } catch (Exception exception) {
            logger.error(exception.getStackTrace());
        }
        // TODO get key using loadProperties
        // TODO get the service, which will require authorization
    }

    private YouTube getService() throws GeneralSecurityException, IOException {
        NetHttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
        Credential credential;// TODO authorize
        YouTube.Builder(httpTransport, JSON_FACTORY, credential).setApplicationName(APPLICATION_NAME).build();
    }

    public String getVideoName(String id) {


        YouTube.Videos.List request;
        return "";
    }
}
