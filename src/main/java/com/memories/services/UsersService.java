package com.memories.services;

import com.memories.domain.User;
import com.memories.persistence.AbstractDao;
import com.memories.persistence.UsersDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService extends DataService<User> {

    @Autowired
    private UsersDao usersDao;

    public User findByLogin(String login) {
        usersDao.openSession();
        User user = usersDao.findByLogin(login);
        usersDao.closeSession();
        return user;
    }

    @Override
    protected AbstractDao<User> getDao() {
        return usersDao;
    }
}
