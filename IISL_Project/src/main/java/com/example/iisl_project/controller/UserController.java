package com.example.iisl_project.controller;

import com.example.iisl_project.model.entity.User;
import com.example.iisl_project.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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


    @GetMapping("update")
    public User updateUser(@RequestParam("id")int id){
        User user = userService.getUserById(id);
        user.setName("Yiwen");
        return userService.updateUser(user);
    }

    @GetMapping("delete/{id}")
    public boolean deleteUser(@PathVariable("id") int id){
        return userService.deleteUser(id);
    }

}
