package net.splatspot.persistence;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.youtube.model.Video;
import com.google.api.services.youtube.model.VideoSnippet;
import edu.matc.utilities.PropertiesLoader;

import com.google.api.services.youtube.YouTube;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.Properties;

/**
 * A class for accessing data from YouTube.
 * Based in part on Java example from https://developers.google.com/youtube/v3/code_samples/code_snippets?apix=true
 */
public class YouTubeAccess implements PropertiesLoader {

    /**
     * The logger.
     */
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * The properties from the 'youtube.properties' file.
     */
    private Properties properties;

    /**
     * The Jackson-based JSON factory.
     */
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();

    /**
     * The name of the application.
     */
    private static String APPLICATION_NAME;

    /**
     * The API key to access the service.
     */
    private String API_KEY;

    /**
     * Represents the YouTube service.
     */
    private YouTube youtubeService;


    /**
     * Instantiates a new YouTube access object.
     */
    public YouTubeAccess() {
        try {
            properties = loadProperties("/youtube.properties");
            APPLICATION_NAME = properties.getProperty("application_name");
            API_KEY = properties.getProperty("key");
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

    /**
     * Gets the YouTube service.
     *
     * @return the YouTube service
     * @throws GeneralSecurityException
     * @throws IOException
     */
    private YouTube getService() throws GeneralSecurityException, IOException {
        NetHttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
        return new
                YouTube.Builder(httpTransport, JSON_FACTORY, null).setApplicationName(APPLICATION_NAME).build();
    }

    /**
     * Gets video information as a VideoSnippet.
     *
     * @param id the id
     * @return the video snippet
     * @throws IOException the io exception
     */
    public VideoSnippet getVideoSnippet(String id) throws IOException {
        YouTube.Videos.List request = youtubeService.videos().list("snippet");
        YouTube.Videos.List videoList= request.setId(id);
        List response = (List) videoList.setKey(API_KEY).execute().get("items");
        Video video = (Video) response.get(0);
        return video.getSnippet();
    }
}
