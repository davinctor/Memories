package com.memories.persistence;


import com.memories.domain.Picture;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PicturesDao extends AbstractDao<Picture> {

    @Override
    public Picture findById(Long id) {
        return (Picture) getCurrentSession().get(Picture.class, id);
    }

    @Override
    public List<Picture> findAll() {
        return getCurrentSession().createQuery("from Picture").list();
    }
}
