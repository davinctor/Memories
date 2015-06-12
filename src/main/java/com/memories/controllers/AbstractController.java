package com.memories.controllers;

import com.memories.domain.User;
import com.memories.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@SessionAttributes("curUser")
public abstract class AbstractController {

    @Autowired
    private UsersService usersService;

    @ModelAttribute("curUser")
    public User getCurrentUser(Principal principal) {
        return usersService.findByLogin(principal.getName());
    }

    @ResponseBody
    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public String error(@RequestParam("errorText") String errorText) {
        return errorText;
    }
}
