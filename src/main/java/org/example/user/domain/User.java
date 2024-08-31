package org.example.user.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;

import java.sql.Date;

@Setter
@Getter
@Entity
public class User {

    @Id
    @Column(name = "uid")
    private String uid;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String phone;

    @Column
    private Date birth;

    @Column
    private String gender;

    @Column
    @CreatedBy
    private Date createdAt;

    // Getters and Setters
}