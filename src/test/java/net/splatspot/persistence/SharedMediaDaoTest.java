package net.splatspot.persistence;

import edu.matc.util.Database;
import net.splatspot.entity.SharedMedia;
import net.splatspot.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


/**
 * The test for Dao with SharedMedia.
 */
public class SharedMediaDaoTest {
    /**
     * The Shared media dao.
     */
    Dao<SharedMedia> sharedMediaDao;

    /**
     * Sets up the SharedMedia Dao.
     */
    @BeforeEach
    void setup() {
        Database database = Database.getInstance();
        database.runSQL("cleanup.sql");
        sharedMediaDao = new Dao<>(SharedMedia.class);
    }

    /**
     * Tests inserting a SharedMedia instance.
     */
    @Test
    void insertSharedMedia() {
        int id;
        String testLink = "P-xkS-csYhE";
        SharedMedia sharedMedia = new SharedMedia();
        sharedMedia.setLink(testLink);

        Dao<User> userDao = new Dao<>(User.class);
        User user = userDao.getById(2);

        sharedMedia.setUser(user);
        user.addSharedMedia(sharedMedia);

        id = sharedMediaDao.insert(sharedMedia);

        SharedMedia result = sharedMediaDao.getById(id);
        assertEquals(testLink, result.getLink());
        assertEquals(user.getNickname(), result.getUser().getNickname());
    }

    /**
     * Tests getting all shared media.
     */
    @Test
    void getAllSharedMedia() {
        List<SharedMedia> sharedMediaList = sharedMediaDao.getAll();
        assertEquals(4, sharedMediaList.size());
    }

    /**
     * Tests getting shared media by ID.
     */
    @Test
    void getSharedMedia() {
        SharedMedia sharedMedia = sharedMediaDao.getById(46);
        assertEquals("L1s3NnhEK0g", sharedMedia.getLink());
    }

    /**
     * Tests updating a link for SharedMedia.
     */
    @Test
    void updateSharedMediaLink() {
        int id = 47;
        String newLink = "cJQRBlnoKHE";
        SharedMedia sharedMedia = sharedMediaDao.getById(id);
        sharedMedia.setLink(newLink);
        sharedMediaDao.update(sharedMedia);
        SharedMedia sharedMedia2 = sharedMediaDao.getById(id);
        assertEquals(newLink, sharedMedia2.getLink());
    }

    /**
     * Tests deleting shared media, without deleting the user
     */
    @Test
    void deleteSharedMedia() {
        Dao<User> userDao = new Dao<>(User.class);
        int sharedMediaId = 45;
        SharedMedia sharedMedia = sharedMediaDao.getById(sharedMediaId);
        User user = sharedMedia.getUser();
        sharedMediaDao.delete(sharedMedia);
        assertNull(sharedMediaDao.getById(sharedMediaId));
        assertEquals(user.getNickname(), userDao.getById(user.getId()).getNickname());
    }

    /**
     * Tests returning null when there ar no record of SharedMedia.
     */
    @Test
    void returnNullWhenNoRecords() {
        Database database = Database.getInstance();
        database.runSQL("empty_tables.sql");
        List<SharedMedia> sharedMediaList = sharedMediaDao.getAll();
        assertTrue(sharedMediaList.isEmpty());
    }

    /**
     * Return null when no SharedMedia record has an Id.
     */
    @Test
    void returnNullWhenNoRecordOfId() {
        SharedMedia sharedMedia = sharedMediaDao.getById(404);
        assertNull(sharedMedia);
    }

    /**
     * Tests returning null when no record match an expected property.
     */
    @Test
    void returnNullWhenNoMatchingRecords() {
        List<SharedMedia> sharedMediaList = sharedMediaDao.getByProperty("link", "example.org");
        assertTrue(sharedMediaList.isEmpty());
    }
}
