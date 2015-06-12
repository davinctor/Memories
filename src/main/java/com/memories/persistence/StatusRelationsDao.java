package com.memories.persistence;


import com.memories.domain.StatusRelation;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StatusRelationsDao extends AbstractDao<StatusRelation> {

    @Override
    public StatusRelation findById(Long id) {
        return (StatusRelation) getCurrentSession().get(StatusRelation.class, id);
    }

    @Override
    public List<StatusRelation> findAll() {
        return getCurrentSession().createQuery("from StatusRelation").list();
    }
}
