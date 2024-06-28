package com.example.demo.service;

import com.example.demo.controller.UserController;
import com.example.demo.model.User;
import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(String email);
    User createUser(User user);
    User updateUser(String email, User userDetails);
    void deleteUser(String mail);
    User loginUser(String email, String password);
    List<User> findMatchingUsers(UserController.Selectoption selectoption);
    
}
