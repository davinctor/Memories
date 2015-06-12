package com.memories.services;

import com.memories.domain.Mood;
import com.memories.persistence.AbstractDao;
import com.memories.persistence.MoodsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MoodsService extends DataService<Mood> {

    @Autowired
    private MoodsDao moodsDao;

    @Override
    protected AbstractDao<Mood> getDao() {
        return moodsDao;
    }
}
