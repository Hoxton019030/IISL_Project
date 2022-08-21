package com.example.iisl_project.model.service;

import com.example.iisl_project.model.dao.UserDao;
import com.example.iisl_project.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = "user")
public class UserService {
    @Autowired
    private UserDao userDao;

    @Cacheable(key = "#id")
    public User getUserById(int id) {
        System.out.println("get");
        return userDao.findById(id).get();
    }

    @CachePut(key = "#result.id")
    public User updateUser(User user ){
        System.out.println("update");
        return userDao.save(user);
    }

    @CacheEvict(key="#id")
    public boolean deleteUser(int id){
        System.out.println("delete User");
        userDao.deleteById(id);
        return true;
    }

}
