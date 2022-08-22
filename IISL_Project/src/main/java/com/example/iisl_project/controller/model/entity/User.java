package com.example.iisl_project.controller.model.entity;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SEQ", columnDefinition = "INTEGER", nullable = false)
    private Integer sqe;

    /**
     * Encrypto
     */
    @Column(name = "ID", columnDefinition = "CHARACTER VARYING(150", nullable = false, length = 150)
    private String id;

    /**
     * First and last name
     */
    @Column(name = "NAME", columnDefinition = "CHARACTER VARYING(200)", nullable = false)
    private String name;

    /**
     * password(hashcode)
     */
    @Column(name = "CODE", columnDefinition = "CHARACTER VARYING(500)", nullable = false)
    private String code;

    /**
     * create time
     */
    @Column(name = "CREATE_TIME", columnDefinition = "TIMESTAMP default FORMATDATETIME(LOCALTIMESTAMP(),'yyyy-MM-dd HH:mm:ss'", nullable = false)
    private LocalDateTime createTime;


    /**
     * update time
     */
    @Column(name = "UPDATE_TIME", columnDefinition = "TIMESTAMP", nullable = true)
    private LocalDateTime updateTime;


}
