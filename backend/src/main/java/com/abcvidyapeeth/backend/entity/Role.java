package com.abcvidyapeeth.backend.entity;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    
}
