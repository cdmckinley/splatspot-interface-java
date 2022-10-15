package net.splatspot.persistence;

import edu.matc.persistence.SessionFactoryProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * A loose re-creation of Paula Waite's generic DAO, which was somewhat inspired by http://rodrigouchoa.wordpress.com
 *
 * @param <T> the type of entity to access data for
 */
public class Dao<T> {
    /**
     * The type of entity to access data for
     */
    private Class<T> type;

    /**
     * The logger
     */
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Instantiates a new Dao.
     *
     * @param type the type of data to be accessed
     */
    public Dao(Class<T> type) {
        this.type = type;
    }

    /**
     * Gets a session from the SessionFactory
     * @return the session
     */
    private Session getSession() {
        return SessionFactoryProvider.getSessionFactory().openSession();
    }

    public int insert(T entity) {
        int id;
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(entity);
        transaction.commit();
        logger.debug("Added entity of type " + type + " with id of " + id);
        return id;

    }

    /**
     * Gets an entity by id.
     *
     * @param id  the entity's id
     * @return the entity
     */
    public T getById(int id) {
        T entity;
        Session session = getSession();
        entity = session.get(type, id);
        session.close();
        return entity;
    }

    /**
     * Gets all of a type of entity.
     *
     * @return the all
     */
    public List<T> getAll() {
        List<T> entityList;
        Session session = getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        query.from(type);
        entityList = session.createQuery(query).getResultList();
        session.close();
        logger.debug("Found " + entityList.size() + " entities of class " + type.getName());
        return entityList;
    }

    /**
     * Gets an entity by property.
     *
     * @param property         the property
     * @param expectedValue the expected value
     * @return list of users that have that property
     */
    public List<T> getByProperty(String property, Object expectedValue) {
        List<T> entityList;
        Session session = getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        Expression<String> propertyPath = root.get(property);
        query.where(builder.equal(propertyPath, expectedValue));
        entityList = session.createQuery(query).getResultList();
        session.close();
        logger.debug("Found " + entityList.size() + " entities of class " + type.getName() + " with property " +
                property + " having value of " + expectedValue);
        return entityList;
    }

    /**
     * Update entity.
     *
     * @param entity the entity
     */
    public void update(T entity) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.update(entity);
        transaction.commit();
        session.close();
    }

    /**
     * Delete.
     *
     * @param entity the entity
     */
    public void delete(T entity) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(entity);
        transaction.commit();
        session.close();
    }
}
