package com.memories.persistence;

import com.memories.domain.Mood;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MoodsDao extends AbstractDao<Mood> {

    @Override
    public Mood findById(Long id) {
        return (Mood) getCurrentSession().get(Mood.class, id);
    }

    @Override
    public List<Mood> findAll() {
        return getCurrentSession().createQuery("from Mood").list();
    }

}
