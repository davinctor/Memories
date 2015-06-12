package com.memories.services;

import com.memories.domain.Memory;
import com.memories.persistence.AbstractDao;
import com.memories.persistence.MemoriesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemoriesService extends DataService<Memory> {

    @Autowired
    private MemoriesDao memoriesDao;

    @Override
    protected AbstractDao<Memory> getDao() {
        return memoriesDao;
    }
}
