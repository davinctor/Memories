package com.memories.controllers;

import com.memories.domain.Memory;
import com.memories.domain.User;
import com.memories.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class UserController {

    @Autowired
    private UsersService usersService;

    @RequestMapping(value = "/ulogin", method = RequestMethod.GET )
    @ResponseBody
    public User userByLogin(@RequestParam(value="login") String login) {
        User user = usersService.findByLogin(login);
        user.setMemories(new ArrayList<Memory>());
        return user;
    }

    @RequestMapping(value = "/uid", method = RequestMethod.GET )
    @ResponseBody
    public User userById(@RequestParam(value="id") Long id) {
        User user = usersService.findById(id);
        user.setMemories(new ArrayList<Memory>());
        return user;
    }

}
