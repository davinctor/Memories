package com.memories.services;

import com.memories.domain.StatusRelation;
import com.memories.persistence.AbstractDao;
import com.memories.persistence.StatusRelationsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusRelationsService extends DataService<StatusRelation> {

    @Autowired
    private StatusRelationsDao statusRelationDao;

    @Override
    protected AbstractDao<StatusRelation> getDao() {
        return statusRelationDao;
    }
}
