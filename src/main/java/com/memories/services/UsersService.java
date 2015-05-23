package com.memories.services;

import com.memories.domain.User;
import com.memories.persistence.UsersDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UsersService extends UsersDao {

    @Autowired
    private UsersDao usersDao;

    public void persist(User entity) {
        usersDao.openSessionWithTransaction();
        usersDao.persist(entity);
        usersDao.closeSessionWithCommitTransaction();
    }

    public void update(User entity) {
        usersDao.openSessionWithTransaction();
        usersDao.update(entity);
        usersDao.closeSessionWithCommitTransaction();
    }

    public User findById(Long id) {
        usersDao.openSession();
        User user = usersDao.findById(id);
        usersDao.closeSession();
        return user;
    }

    public User findByLogin(String login) {
        usersDao.openSession();
        User user = usersDao.findByLogin(login);
        usersDao.closeSession();
        return user;
    }

    public void delete(Long id) {
        usersDao.openSessionWithTransaction();
        User user = usersDao.findById(id);
        usersDao.delete(user);
        usersDao.closeSessionWithCommitTransaction();
    }

    public List<User> findAll() {
        usersDao.openSession();
        List<User> listUsers = usersDao.findAll();
        usersDao.closeSession();
        return listUsers;
    }

    public void deleteAll() {
        usersDao.openSessionWithTransaction();
        usersDao.deleteAll();
        usersDao.closeSessionWithCommitTransaction();
    }
}
