package net.splatspot.persistence;

import edu.matc.persistence.SessionFactoryProvider;
import net.splatspot.entity.SharedMedia;
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
 * The SharedMedia Data Access Object.
 */
public class SharedMediaDao {

    /**
     * The logger
     */
    private final Logger logger = LogManager.getLogger(SharedMediaDao.class);
    /**
     * The Session factory.
     */
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Instantiates a new SharedMedia dao.
     */
    public SharedMediaDao() {
    }

    /**
     * Insert a SharedMedia instance into the database.
     *
     * @param sharedMedia the SharedMedia object
     * @return the id of the SharedMedia
     */
    public int insertSharedMedia(SharedMedia sharedMedia) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(sharedMedia);
        logger.debug("Added media with id of " + id);
        transaction.commit();
        session.close();
        return id;
    }

    /**
     * Gets all shared media.
     *
     * @return all the shared media
     */
    public List<SharedMedia> getAllSharedMedia() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<SharedMedia> query = builder.createQuery(SharedMedia.class);
        Root<SharedMedia> root = query.from(SharedMedia.class);
        List<SharedMedia> sharedMediaList = session.createQuery(query).getResultList();
        session.close();
        return sharedMediaList;
    }

    /**
     * Gets shared media.
     *
     * @param id the shared media's id
     * @return the SharedMedia instance
     */
    public SharedMedia getSharedMedia(int id) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<SharedMedia> query = builder.createQuery(SharedMedia.class);
        Root<SharedMedia> root = query.from(SharedMedia.class);
        Expression<String> propertyPath = root.get("id");
        query.where(builder.equal(propertyPath, id));
        List<SharedMedia> sharedMediaList = session.createQuery(query).getResultList();
        SharedMedia sharedMedia = null;
        if (sharedMediaList.size() == 1) {
            sharedMedia = sharedMediaList.get(0);
            logger.debug("Found SharedMedia on User with ID of " + sharedMedia.getUser().getId());
        } else {
            logger.debug("No SharedMedia was found");
        }
        session.close();
        return sharedMedia;
    }

    /**
     * Update SharedMedia link.
     *
     * @param id       the id of the SharedMedia instance
     * @param link the link
     */
    public void updateMediaLink(int id, String link) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<SharedMedia> query = builder.createQuery(SharedMedia.class);
        Root<SharedMedia> root = query.from(SharedMedia.class);
        Expression<String> propertyPath = root.get("id");
        query.where(builder.equal(propertyPath, id));
        List<SharedMedia> sharedMediaList = session.createQuery(query).getResultList();
        SharedMedia sharedMedia = null;
        if (sharedMediaList.size() == 1) {
            sharedMedia = sharedMediaList.get(0);
            sharedMedia.setLink(link);
            Transaction transaction = session.beginTransaction();
            session.update(sharedMedia);
            transaction.commit();
        }

        session.close();
    }

    /**
     * Delete SharedMedia instance.
     *
     * @param id the SharedMedia id
     */
    public void deleteSharedMedia(int id) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<SharedMedia> query = builder.createQuery(SharedMedia.class);
        Root<SharedMedia> root = query.from(SharedMedia.class);
        Expression<String> propertyPath = root.get("id");
        query.where(builder.equal(propertyPath, id));
        List<SharedMedia> sharedMediaList = session.createQuery(query).getResultList();
        SharedMedia sharedMedia = null;
        if (sharedMediaList.size() == 1) {
            sharedMedia = sharedMediaList.get(0);
            Transaction transaction = session.beginTransaction();
            session.delete(sharedMedia);
            transaction.commit();
        }

        session.close();
    }
}
