package com.memories.services;

import com.memories.domain.Memory;
import com.memories.dto.MemoryVO;
import com.memories.persistence.AbstractDao;
import com.memories.persistence.MemoriesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemoriesService extends DataService<Memory> {

    @Autowired
    private MemoriesDao memoriesDao;

    @Override
    protected AbstractDao<Memory> getDao() {
        return memoriesDao;
    }

    public List<MemoryVO> findVOByUserId(Long id) {
        memoriesDao.openSession();
        List<MemoryVO> list = memoriesDao.findVOByUserId(id);
        memoriesDao.closeSession();
        return list;
    }

    public List<MemoryVO> findVOByUserLogin(String login) {
        memoriesDao.openSession();
        List<MemoryVO> list = memoriesDao.findVOByUserLogin(login);
        memoriesDao.closeSession();
        return list;
    }
}
