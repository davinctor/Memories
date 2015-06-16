package com.memories.controllers;

import com.memories.domain.Memory;
import com.memories.dto.MemoryVO;
import com.memories.services.MemoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/memory")
// ToDo: send memories by parts
public class MemoriesController extends AbstractController {

    @Autowired
    private MemoriesService memoriesService;

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Memory getMemoryById(@PathVariable("id") Long id,
                                HttpServletResponse response) throws ServletException, IOException {
        Memory memory = memoriesService.findById(id);
        if (memory == null) {
            response.sendRedirect("/memory/error/"
                    + "?errorText=" + "Memory with id:" + id + " doesn't exists.");
            return null;
        }
        return memory;
    }

    @ResponseBody
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public List<MemoryVO> getMemoriesByUserId(@RequestParam(value = "id",required = false) Long id,
                                              @RequestParam(value = "login",required = false) String login,
                                                 HttpServletResponse response)
            throws ServletException, IOException {
        List<MemoryVO> list;
        if (id != null)
            list = memoriesService.findVOByUserId(id);
        else
            list = memoriesService.findVOByUserLogin(login);
        if (list.isEmpty()) {
            response.sendRedirect("/memory/error/"
                    + "?errorText=" + "Memories not found, id: " + id);
            return null;
        }
        return list;
    }
}
