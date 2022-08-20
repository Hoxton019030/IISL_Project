package com.example.iisl_project.model.service;

import com.example.iisl_project.model.dao.UserDao;
import com.example.iisl_project.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    @Cacheable(value = "user")
    public User getUserById(int id) {
        return userDao.findById(id).get();
    }

}
