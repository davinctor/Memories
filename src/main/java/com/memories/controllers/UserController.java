package com.memories.controllers;

import com.memories.domain.User;
import com.memories.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    UsersService usersService;

    @RequestMapping(value = "/user", method = RequestMethod.GET )
    @ResponseBody
    public User user(@RequestParam(value="login") String login) {
        return usersService.findByLogin(login);
    }
}
