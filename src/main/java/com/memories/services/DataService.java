package com.memories.services;

import com.memories.persistence.AbstractDao;

import java.util.List;

public abstract class DataService<T> {

    protected abstract AbstractDao<T> getDao();

    public void persist(T entity) {
        getDao().openSessionWithTransaction();
        getDao().persist(entity);
        getDao().closeSessionWithCommitTransaction();
    }

    public void update(T entity) {
        getDao().openSessionWithTransaction();
        getDao().update(entity);
        getDao().closeSessionWithCommitTransaction();
    }

    public T findById(Long id) {
        getDao().openSession();
        T obj = getDao().findById(id);
        getDao().closeSession();
        return obj;
    }

    public void delete(Long id) {
        getDao().openSessionWithTransaction();
        T obj = getDao().findById(id);
        getDao().delete(obj);
        getDao().closeSessionWithCommitTransaction();
    }

    public List<T> findAll() {
        getDao().openSession();
        List<T> list = getDao().findAll();
        getDao().closeSession();
        return list;
    }

    public void deleteAll() {
        getDao().openSessionWithTransaction();
        getDao().deleteAll();
        getDao().closeSessionWithCommitTransaction();
    }
}
