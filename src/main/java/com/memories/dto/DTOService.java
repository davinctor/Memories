package com.memories.dto;

import com.memories.domain.Memory;
import com.memories.services.MemoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DTOService {

    @Autowired
    private MemoriesService memoriesService;

    public Memory findMemoryById(Long id) {
        Memory memory = memoriesService.findById(id);
        if (memory != null) {
            memory.getMood().setMemories(null);
            memory.getUser().setMemories(null);
        }
        return memory;
    }

}