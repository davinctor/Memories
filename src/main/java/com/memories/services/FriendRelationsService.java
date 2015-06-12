package com.memories.services;

import com.memories.persistence.AbstractDao;
import com.memories.util.Util;
import com.memories.domain.FriendRelation;
import com.memories.persistence.FriendRelationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendRelationsService extends DataService<FriendRelation> {

    @Autowired
    private FriendRelationsRepository friendRelationsRepository;

    @Override
    public void persist(FriendRelation entity) {
        friendRelationsRepository.save(entity);
    }

    @Override
    public void update(FriendRelation entity) {
        friendRelationsRepository.save(entity);
    }

    @Override
    public FriendRelation findById(Long id) {
        return friendRelationsRepository.findOne(id);
    }

    @Override
    public void delete(Long id) {
        friendRelationsRepository.delete(id);
    }

    @Override
    public List<FriendRelation> findAll() {
        return Util.makeCollection(friendRelationsRepository.findAll());
    }

    @Override
    public void deleteAll() {
        friendRelationsRepository.deleteAll();
    }

    @Override
    protected AbstractDao<FriendRelation> getDao() {
        return null;
    }
}
