package net.splatspot.persistence;

import edu.matc.util.Database;
import net.splatspot.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

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
        id = userDao.insertUser(user);
        assertNotNull(userDao.getUser(id));
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
        String newNickname = "Nickname2";
        userDao.updateUserNickname(1, newNickname);
        User user = userDao.getUser(1);
        assertEquals(user.getNickname(), newNickname);
    }

    /**
     * Tests deleting a user.
     */
    @Test
    void deleteUser() {
        userDao.deleteUser(1);
        assertNull(userDao.getUser(1));
    }
}
