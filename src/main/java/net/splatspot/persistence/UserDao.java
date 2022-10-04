package net.splatspot.persistence;

import edu.matc.persistence.SessionFactoryProvider;
import net.splatspot.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

import java.util.List;

/**
 * The User Data Access Object.
 */
public class UserDao {

    /**
     * The logger
     */
    private final Logger logger = LogManager.getLogger(UserDao.class);
    /**
     * The Session factory.
     */
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Instantiates a new User dao.
     */
    public UserDao() {
    }

    /**
     * Insert a user into the database.
     *
     * @param user the user object
     * @return the id of the user
     */
    public int insertUser(User user) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(user);
        logger.debug("Added user with id of " + id);
        transaction.commit();
        session.close();
        return id;
    }

    /**
     * Gets all users.
     *
     * @return the all users
     */
    public List<User> getAllUsers() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> root = query.from(User.class);
        List<User> users = session.createQuery(query).getResultList();
        session.close();
        return users;
    }

    /**
     * Gets user.
     *
     * @param id the user's id
     * @return the user
     */
    public User getUser(int id) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> root = query.from(User.class);
        Expression<String> propertyPath = root.get("id");
        query.where(builder.equal(propertyPath, id));
        List<User> users = session.createQuery(query).getResultList();
        User user = null;
        if (users.size() == 1) {
            user = users.get(0);
        }
        session.close();
        return user;
    }

    /**
     * Update user nickname.
     *
     * @param id       the id of the user
     * @param nickname the nickname
     */
    public void updateUserNickname(int id, String nickname) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> root = query.from(User.class);
        Expression<String> propertyPath = root.get("id");
        query.where(builder.equal(propertyPath, id));
        List<User> users = session.createQuery(query).getResultList();
        User user = users.get(0);
        user.setNickname(nickname);
        Transaction transaction = session.beginTransaction();
        session.update(user);
        transaction.commit();
        session.close();
    }

    /**
     * Delete user.
     *
     * @param id the user id
     */
    public void deleteUser(int id) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> root = query.from(User.class);
        Expression<String> propertyPath = root.get("id");
        query.where(builder.equal(propertyPath, id));
        List<User> users = session.createQuery(query).getResultList();
        User user = users.get(0);
        Transaction transaction = session.beginTransaction();
        session.delete(user);
        transaction.commit();
        session.close();
    }
}
