package com.example.iisl_project.controller;

import com.example.iisl_project.util.JwtToken;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class TestController {
    @RequestMapping("/")
    public String helloWorld(){
        return "Hello World";
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody HashMap<String,String> user){
        JwtToken jwtToken = new JwtToken();
        String token = jwtToken.generateToken(user);
        return ResponseEntity.status(HttpStatus.OK).body(token);
    }
}
