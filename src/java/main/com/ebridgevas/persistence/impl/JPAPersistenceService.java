package com.ebridgevas.persistence.impl;

import com.ebridgevas.persistence.PersistenceService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.io.Serializable;
import java.util.List;

/**
 * @author david@tekeshe.com
 */
public class JPAPersistenceService <T, Id extends Serializable> implements PersistenceService<T, Id> {

    private Session currentSession;

    private Transaction currentTransaction;

    public Session openCurrentSession() {
        currentSession = sessionFactory().openSession();
        return currentSession;
    }

    public Session openCurrentSessionWithTransaction() {

        currentSession = sessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }

    public void closeCurrentSession() {
        currentSession.close();
    }

    public void closeCurrentSessionWithTransaction(Boolean commit) {

        if (commit ) currentTransaction.commit();
        else currentTransaction.rollback();

        currentSession.close();
    }

    public Session getCurrentSession() {
        return currentSession;
    }

    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }

    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }

    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }

    private static SessionFactory sessionFactory() {

        Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder builder
                = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        return configuration.buildSessionFactory( builder.build());
    }

    @Override
    public void persist(T entity) {

        try {
            openCurrentSessionWithTransaction();
            getCurrentSession().save(entity);
        } finally {
            closeCurrentSessionWithTransaction(true);
        }
    }

    @Override
    public void update(T entity) {
        getCurrentSession().update( entity );
    }

    @Override
    public T findById(Class<T> t, Id id) {
        try {
            openCurrentSession();
            return (T) getCurrentSession().get(t, id);
        } finally {
            closeCurrentSession();
        }
    }

    @Override
    public void delete(T entity) {

        try {
            openCurrentSessionWithTransaction();
            getCurrentSession().delete(entity);
        } finally {
            closeCurrentSessionWithTransaction(true);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<T> findAll(Class<T> t) {
        try {
            openCurrentSession();
            System.out.println("from " + t.getSimpleName());
            return  getCurrentSession().createQuery("from " + t.getSimpleName() ).list();
        } finally {
            closeCurrentSession();
        }
    }

    @Override
    public void deleteAll(Class<T> t) {

        try {
            List<T> entries = findAll(t);
            openCurrentSessionWithTransaction();
            for (T entry : entries ) {
                getCurrentSession().delete( entry );
            }
        } finally {
            closeCurrentSessionWithTransaction(true);
        }
    }
}
