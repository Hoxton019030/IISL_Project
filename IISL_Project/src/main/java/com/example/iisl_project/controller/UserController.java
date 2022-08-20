package com.example.iisl_project.controller;

import com.example.iisl_project.model.entity.User;
import com.example.iisl_project.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Controller
@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping(value = "user/{id}")
    public User getUser(@PathVariable("id") int id){
        return userService.getUserById(id);
    }

}
