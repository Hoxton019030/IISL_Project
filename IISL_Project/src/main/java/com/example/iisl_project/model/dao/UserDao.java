package com.example.iisl_project.model.dao;

import com.example.iisl_project.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Repository
public interface UserDao extends JpaRepository<User, Integer> {


}
