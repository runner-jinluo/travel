package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(String id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(String email, User userDetails) {
        User user = userRepository.findById(email).orElse(null);
        if (user != null) {
            user.setPassword(userDetails.getPassword());
            user.setInterest(userDetails.getInterest());
            user.setName(userDetails.getName());
            user.setAge(userDetails.getAge());
            user.setSex(userDetails.getSex());
            user.setPhoneNumber(userDetails.getPhoneNumber());
            return userRepository.save(user);
        }
        return null;
    }

    @Override
    public void deleteUser(String mail) {
        userRepository.deleteById(mail);
    }

    @Override
    public User loginUser(String email, String password) {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }
}
