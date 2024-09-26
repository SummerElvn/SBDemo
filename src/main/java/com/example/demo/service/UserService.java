package com.example.demo.service;

import com.example.demo.model.dbentities.User;

import java.util.List;

public interface UserService {
    User createUser(User user);

    User getUserById(String userId);

    List<User> getAllUsers();

    User updateUser(User user);

    void deleteUser(String userId);
}