package com.memories.services;


import com.memories.domain.Picture;
import com.memories.persistence.AbstractDao;
import com.memories.persistence.PicturesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PicturesService extends DataService<Picture> {

    @Autowired
    private PicturesDao picturesDao;

    @Override
    protected AbstractDao<Picture> getDao() {
        return picturesDao;
    }
}
