package com.jerry.springboot_junit4.service;

import com.jerry.springboot_junit4.entity.User;

import java.util.List;

public interface UserService {
    User save(User user);
    User findById(String id);
    void delete(User user);
    List<User> findAll();
}
