package com.memories.controllers;

import com.memories.domain.Memory;
import com.memories.dto.DTOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/memory")
// ToDo: send memories by user name
// ToDo: send memories by parts
public class MemoriesController extends AbstractController {

    @Autowired
    private DTOService dtoService;

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Memory getMemoryById(@PathVariable("id") Long id,
                                HttpServletResponse response) throws ServletException, IOException {
        Memory memory = dtoService.findMemoryById(id);
        if (memory == null) {
            response.sendRedirect("/memory/error/"
                    + "?errorText=" + "Memory with id:" + id + " doesn't exists.");
            return null;
        }
        return dtoService.findMemoryById(id);
    }
}
