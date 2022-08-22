package com.example.iisl_project.controller.model.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name="ARTICLEID",nullable = false, columnDefinition = "INTEGER")
    private Integer articleId;

    @Column(name="commentConment",nullable = false,columnDefinition = "CHARACTER VARYING(150)")
    private String commentConment;

}
