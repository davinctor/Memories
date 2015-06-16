package com.memories.persistence;

import com.memories.domain.Memory;
import com.memories.dto.MemoryVO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
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


    public List<MemoryVO> findVOByUserLogin(String login) {
        // ToDo: Use hibernate way of converting bean with field collection
        //      instead of my way of getting standard entity and converting
        //      to DTO with using additional memory to store specified columns of
        //      inner mapping entity in extra collection(list)
        //      i.e. used extra list<string> to store url of memory pictures
        List<Memory> list = getCurrentSession()
                .createQuery("from Memory as m where m.user.login LIKE :login")
                .setString("login", login)
                .list();
        return getMemoriesVoByMemories(list);
    }

    public List<MemoryVO> findVOByUserId(Long id) {
        List<Memory> list = getCurrentSession()
                .createQuery("from Memory as m where m.user.id LIKE :id")
                .setLong("id", id)
                .list();
        return getMemoriesVoByMemories(list);
    }

    private List<MemoryVO> getMemoriesVoByMemories(List<Memory> list) {
        List<MemoryVO> memoryVoList = new ArrayList<MemoryVO>(list.size());
        for (Memory m : list) {
            memoryVoList.add(
                    new MemoryVO(m.getId(),
                            m.getText(),
                            m.getMood().getId(),
                            m.getMoodDescription(),
                            m.getPicturesUrls()));
        }
        return memoryVoList;
    }
}
