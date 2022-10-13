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
    UserDao userDao;
    /**
     * Sets up the UserDao.
     */
    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleanup.sql");
        userDao = new UserDao();
    }

    /**
     * Tests inserting a user into the database.
     */
    @Test
    void insertUser() {
        int id = 0;

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

        id = userDao.insertUser(user);

        User result = userDao.getUser(id);
        assertEquals("JustATest", result.getNickname());
        assertEquals(1, result.getSharedMediaList().size());
    }

    /**
     * Tests getting all users.
     */
    @Test
    void getAllUsers() {
        List<User> users = userDao.getAllUsers();
        assertNotEquals(0, users.size());
    }

    /**
     * Tests getting a user by ID.
     */
    @Test
    void getUser() {
        User user = userDao.getUser(1);
        assertNotNull(user);
    }

    /**
     * Tests updating the user's nickname.
     */
    @Test
    void updateUserNickname() {
        int id = 1;
        String newNickname = "Nickname2";
        userDao.updateUserNickname(id, newNickname);
        User user = userDao.getUser(id);
        assertEquals(user.getNickname(), newNickname);
    }

    /**
     * Tests deleting a user.
     */
    @Test
    void deleteUser() {
        int id = 1;
        User user = userDao.getUser(id);
        userDao.deleteUser(user);
        assertNull(userDao.getUser(id));
    }
}
