package com.example.repa.service;

import com.example.repa.model.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    User updateUser(User user);
    void deleteUser(User user);

    User getUserById(long id);
    User getUserByEmail(String email);
    List<User> getAllUsers();
}
