package net.splatspot.persistence;

import edu.matc.util.Database;
import net.splatspot.entity.SharedMedia;
import net.splatspot.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test for UserDao.
 */
public class UserDaoTest {

    /**
     * The User dao.
     */
    Dao<User> userDao;
    /**
     * Sets up the UserDao.
     */
    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleanup.sql");
        userDao = new Dao<>(User.class);
    }

    /**
     * Tests inserting a user into the database.
     */
    @Test
    void insertUser() {
        int id;

        User user = new User();
        user.setNickname("JustATest");
        user.setFriendCode("SW-5555-5555-5555");
        user.setSplashTagName("TestFirer");
        user.setSplashTagNumber("4567");
        user.setShareInfoWithUsers(false);
        user.setShareWhenReadyToPlay(true);

        SharedMedia sharedMedia = new SharedMedia();
        sharedMedia.setLink("https://twitter.com/discord");

        sharedMedia.setUser(user);
        user.addSharedMedia(sharedMedia);

        id = userDao.insert(user);

        User result = userDao.getById(id);
        assertEquals("JustATest", result.getNickname());
        assertEquals(1, result.getSharedMediaList().size());
    }

    /**
     * Tests getting all users.
     */
    @Test
    void getAllUsers() {
        List<User> users = userDao.getAll();
        assertNotEquals(0, users.size());
    }

    /**
     * Tests getting a user by ID.
     */
    @Test
    void getUser() {
        User user = userDao.getById(1);
        assertEquals("Nick", user.getNickname());
    }

    /**
     * Tests updating the user's nickname.
     */
    @Test
    void updateUserNickname() {
        int id = 1;
        String newNickname = "Nickname2";
        User user = userDao.getById(id);
        user.setNickname(newNickname);
        userDao.update(user);
        User user2 = userDao.getById(id);
        assertEquals(user2.getNickname(), newNickname);
    }

    /**
     * Tests deleting a user.
     */
    @Test
    void deleteUser() {
        int id = 1;
        User user = userDao.getById(id);
        userDao.delete(user);
        assertNull(userDao.getById(id));
    }

    @Test
    void returnNullWhenNoRecords() {
        Database database = Database.getInstance();
        database.runSQL("empty_tables.sql");
        List<User> userList = userDao.getAll();
        assertTrue(userList.isEmpty());
    }

    @Test
    void returnNullWhenNoRecordOfId() {
        User user = userDao.getById(404);
        assertNull(user);
    }

    @Test
    void returnNullWhenNoMatchingRecords() {
        List<User> userList = userDao.getByProperty("nickname", "Agent 404");
        assertTrue(userList.isEmpty());
    }
}
