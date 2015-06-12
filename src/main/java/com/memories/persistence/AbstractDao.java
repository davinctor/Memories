package com.memories.persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public abstract class AbstractDao<T> {

    @Autowired
    SessionFactory sessionFactory;

    private Session currentSession;
    private Transaction currentTransaction;

    public Session openSession() {
        currentSession = sessionFactory.openSession();
        return currentSession;
    }

    public Session openSessionWithTransaction() {
        currentSession = sessionFactory.openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }

    public void closeSession() {
        currentSession.close();
    }

    public void closeSessionWithCommitTransaction() {
        currentTransaction.commit();
        closeSession();
    }

    public Session getCurrentSession() {
        return currentSession;
    }

    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }

    public void persist(T entity) {
        getCurrentSession().persist(entity);
    }

    public void update(T entity) {
        getCurrentSession().update(entity);
    }

    public abstract T findById(Long id);

    public void delete(T entity) {
        getCurrentSession().delete(entity);
    }

    public abstract List<T> findAll();

    public void deleteAll() {
        List<T> list = findAll();
        for (T obj : list)
            delete(obj);
    }

}

