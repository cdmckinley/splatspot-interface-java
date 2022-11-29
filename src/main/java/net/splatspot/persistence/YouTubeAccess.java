package net.splatspot.persistence;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.youtube.model.VideoListResponse;
import edu.matc.utilities.PropertiesLoader;

import com.google.api.services.youtube.YouTube;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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

    private static final String CLIENT_SECRETS = "client_secret.json";
    private static final Collection<String> SCOPES = Arrays.asList("https://www.googleapis.com/auth/youtube.readonly");

    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();

    private static String APPLICATION_NAME;
    private YouTube youtubeService;


    public YouTubeAccess() {
        try {
            properties = loadProperties("/youtube.properties");
            APPLICATION_NAME = properties.getProperty("application_name");
            youtubeService = getService();
        } catch (Exception exception) {
            logger.error(exception.getStackTrace());
        }
        try {
            youtubeService = getService();
        } catch (GeneralSecurityException | IOException exception) {
            logger.error(exception);
        }
    }

    private Credential authorize(final NetHttpTransport httpTransport) throws IOException {
        InputStream inputStream = YouTubeAccess.class.getResourceAsStream(CLIENT_SECRETS);
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(inputStream));
        GoogleAuthorizationCodeFlow codeFlow =
                new GoogleAuthorizationCodeFlow.Builder(httpTransport, JSON_FACTORY, clientSecrets, SCOPES).build();
        Credential credential =
                new AuthorizationCodeInstalledApp(codeFlow, new LocalServerReceiver()).authorize("user"); // May need to enter an ID
        return credential;
    }

    private YouTube getService() throws GeneralSecurityException, IOException {
        NetHttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
        Credential credential = authorize(httpTransport);// TODO authorize
        return new
                YouTube.Builder(httpTransport, JSON_FACTORY, credential).setApplicationName(APPLICATION_NAME).build();
    }

    public VideoListResponse getVideoInformation(String id) throws IOException {
        YouTube.Videos.List request = youtubeService.videos().list("title,channelTitle");
        return request.setId(id).execute();
    } // TODO re-code to use an entity bean, and map the information to that bean
}
