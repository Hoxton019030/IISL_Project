package com.example.iisl_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class IislProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(IislProjectApplication.class, args);
    }

}
