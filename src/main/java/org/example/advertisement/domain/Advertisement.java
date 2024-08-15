package org.example.advertisement.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;

import java.sql.Date;

@Setter
@Getter
@Entity
public class Advertisement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "advertisement_id")
    private Long id;

    @Column
    private String title;

    @Column
    private String url;

    @Column
    private String image;

    @Column
    @CreatedBy
    private Date createdAt;

    // Getters and Setters
}