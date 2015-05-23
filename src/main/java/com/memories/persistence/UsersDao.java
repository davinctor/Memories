package com.memories.persistence;

import com.memories.domain.User;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UsersDao extends AbstractDao<User> {

    @Override
    public void persist(User entity) {
        getCurrentSession().persist(entity);
    }

    @Override
    public void update(User entity) {
        getCurrentSession().update(entity);
    }

    @Override
    public User findById(Long id) {
        return (User) getCurrentSession().get(User.class, id);
    }

    public User findByLogin(String login) {
        Query query = getCurrentSession().createQuery("from User u where u.login = :login");
        query.setParameter("login", login);
        List result = query.list();
        return result.size() > 0 ? (User) result.get(0) : null;
    }

    @Override
    public void delete(User entity) {
        getCurrentSession().delete(entity);
    }

    @Override
    public List<User> findAll() {
        return getCurrentSession().createQuery("from User").list();
    }

    @Override
    public void deleteAll() {
        List<User> list = findAll();
        for (User user : list)
            delete(user);
    }
}
