package com.gorlevskey.task_31._spring_boot.service;

import com.gorlevskey.task_31._spring_boot.model.User;

import java.util.List;

public interface UserService {
    void save(User user);

    User findById(int id);

    List<User> findAll();

    void update(User user, int id);

    void deleteById(int id);
}