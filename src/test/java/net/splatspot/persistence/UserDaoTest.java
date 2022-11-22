package net.splatspot.persistence;

import edu.matc.util.Database;
import net.splatspot.entity.SharedMedia;
import net.splatspot.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test for Dao with User.
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
        user.setUsername("test_user");
        user.setNickname("JustATest");
        user.setFriendCode("SW-5555-5555-5555");
        user.setSplashTagName("TestFirer");
        user.setSplashTagNumber("4567");
        user.setShareInfoWithUsers(false);
        user.setShareWhenReadyToPlay(true);

        SharedMedia sharedMedia = new SharedMedia();
        sharedMedia.setLink("P-xkS-csYhE");

        sharedMedia.setUser(user);
        user.addSharedMedia(sharedMedia);

        id = userDao.insert(user);

        User result = userDao.getById(id);
        assertEquals("JustATest", result.getNickname());
        assertEquals(1, result.getSharedMediaSet().size());
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
        Dao<SharedMedia> sharedMediaDao = new Dao<>(SharedMedia.class);
        int id = 1;
        User user = userDao.getById(id);
        Set<SharedMedia> sharedMediaSet = user.getSharedMediaSet();
        Set<Integer> sharedMediaIdSet = new HashSet<>();
        for (SharedMedia sharedMedia : sharedMediaSet) {
            sharedMediaIdSet.add(sharedMedia.getId());
        }
        userDao.delete(user);
        assertNull(userDao.getById(id));
        for (int sharedMediaId : sharedMediaIdSet) {
            assertNull(sharedMediaDao.getById(sharedMediaId));
        }
    }

    /**
     * Returns null when no User records are found.
     */
    @Test
    void returnEmptyWhenNoRecords() {
        Database database = Database.getInstance();
        database.runSQL("empty_tables.sql");
        List<User> userList = userDao.getAll();
        assertTrue(userList.isEmpty());
    }

    /**
     * Returns null when no record of a User with an ID is found.
     */
    @Test
    void returnNullWhenNoRecordOfId() {
        User user = userDao.getById(404);
        assertNull(user);
    }

    /**
     * Returns null when no records match an expected property.
     */
    @Test
    void returnEmptyWhenNoMatchingRecords() {
        List<User> userList = userDao.getByProperty("nickname", "Agent 404");
        assertTrue(userList.isEmpty());
    }
}
