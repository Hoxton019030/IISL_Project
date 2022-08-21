package com.example.iisl_project.model.service;

import com.example.iisl_project.model.dao.UserDao;
import com.example.iisl_project.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    @Cacheable(value = "user",key = "#id")
    public User getUserById(int id) {
        System.out.println("get");
        return userDao.findById(id).get();
    }

    @CachePut(value = "user",key = "#result.id")
    public User updateUser(User user ){
        System.out.println("update");
        return userDao.save(user);
    }

    @CacheEvict(value = "user" ,key="#id")
    public boolean deleteUser(int id){
        System.out.println("delete User");
        userDao.deleteById(id);
        return true;
    }

}
