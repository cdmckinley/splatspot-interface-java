package net.splatspot.persistence;

import com.google.api.services.youtube.model.VideoSnippet;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

/**
 * Tests for the YouTubeAccess class.
 */
public class YouTubeAccessTest {

    /**
     * The Logger.
     */
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * The YouTube access object.
     */
    YouTubeAccess youTubeAccess;

    /**
     * Sets up the YouTube access object.
     */
    @BeforeEach
    void setup() {
        youTubeAccess = new YouTubeAccess();
    }

    /**
     * Test that the name and channel of a video can be found.
     */
    @Test
    void testNameAndChannel() {
        String videoId = "2Rm4T2K4XZI";
        String expectedName = "Splatoon 3 – Chill Season 2022 Announcement – Nintendo Switch";
        String expectedChannel = "Nintendo of America";
        VideoSnippet snippet = null;
        try {
            snippet = youTubeAccess.getVideoSnippet(videoId);
        } catch (IOException ioe) {
            logger.error(ioe.getStackTrace());
        }
        assertNotNull(snippet);
        assertEquals(expectedName, snippet.getTitle());
        assertEquals(expectedChannel, snippet.getChannelTitle());
    }
}
