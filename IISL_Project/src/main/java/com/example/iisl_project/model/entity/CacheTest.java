package com.example.iisl_project.model.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class CacheTest {
    @Id
    private Long id;

    private String name;

    private int age;

}
