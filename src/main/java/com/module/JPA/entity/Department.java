package com.module.JPA.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Department {
    @Id
    @Column(unique = true)
    private String name;
}
