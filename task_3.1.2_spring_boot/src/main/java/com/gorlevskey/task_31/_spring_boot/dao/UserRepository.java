package com.gorlevskey.task_31._spring_boot.dao;

import com.gorlevskey.task_31._spring_boot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Integer > {

}