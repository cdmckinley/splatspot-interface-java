package net.splatspot.persistence;

import edu.matc.util.Database;
import net.splatspot.entity.SharedMedia;
import net.splatspot.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class SharedMediaDaoTest {
    SharedMediaDao sharedMediaDao;

    @BeforeEach
    void setup() {
        Database database = Database.getInstance();
        database.runSQL("cleanup.sql");
        sharedMediaDao = new SharedMediaDao();
    }

    @Test
    void insertSharedMedia() {
        int id = 0;
        String testLink = "https://twitter.com/NintendoAmerica";
        SharedMedia sharedMedia = new SharedMedia();
        sharedMedia.setLink(testLink);

        UserDao userDao = new UserDao();
        User user = userDao.getUser(2);

        sharedMedia.setUser(user);
        user.addSharedMedia(sharedMedia);

        id = sharedMediaDao.insertSharedMedia(sharedMedia);

        SharedMedia result = sharedMediaDao.getSharedMedia(id);
        assertEquals(testLink, result.getLink());
        assertEquals(user.getNickname(), result.getUser().getNickname());
    }

    @Test
    void getAllSharedMedia() {
        List<SharedMedia> sharedMediaList = sharedMediaDao.getAllSharedMedia();
        assertEquals(3, sharedMediaList.size());
    }

    @Test
    void getSharedMedia() {
        SharedMedia sharedMedia = sharedMediaDao.getSharedMedia(46);
        assertEquals("https://twitter.com/discord", sharedMedia.getLink());
    }

    @Test
    void updateSharedMediaLink() {
        int id = 47;
        String newLink = "https://twitter.com/NintendoAmerica";
        sharedMediaDao.updateMediaLink(id, newLink);
        SharedMedia sharedMedia = sharedMediaDao.getSharedMedia(id);
        assertEquals(newLink, sharedMedia.getLink());
    }

    @Test
    void deleteSharedMedia() {
        int id = 45;
        SharedMedia sharedMedia = sharedMediaDao.getSharedMedia(id);
        sharedMediaDao.deleteSharedMedia(sharedMedia);
        assertNull(sharedMediaDao.getSharedMedia(id));
    }
}
