package com.jerry.springboot_junit4.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "user")
@Setter
@Getter
public class User extends BaseEntity {
    @Column(name = "name",length = 100)
    private String name;
    @Column(name = "age")
    private int age;
}
