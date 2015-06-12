package com.memories.persistence;

import com.memories.domain.Memory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemoriesDao extends AbstractDao<Memory> {

    @Override
    public Memory findById(Long id) {
        return (Memory) getCurrentSession().get(Memory.class, id);
    }

    @Override
    public List<Memory> findAll() {
        return getCurrentSession().createQuery("from Memory").list();
    }
}
