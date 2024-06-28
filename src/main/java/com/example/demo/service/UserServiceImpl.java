package com.example.demo.service;

import com.example.demo.controller.UserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @Override
    public List<User> findMatchingUsers(UserController.Selectoption selectoption) {

        Integer minAge = selectoption.minage;
        Integer maxAge = selectoption.maxage;
        String currentUserInterest = selectoption.interest;

        System.out.println("Current user interest: " + currentUserInterest);


        List<User> candidates;
        if (selectoption.sex == "01"){
            String sex = "女";
            candidates = userRepository.findByAgeBetweenAndSex(minAge, maxAge, sex);
        } else if (selectoption.sex == "10") {
            String sex = "男";
            candidates = userRepository.findByAgeBetweenAndSex(minAge, maxAge, sex);
        } else {
            candidates = userRepository.findByAgeBetween(minAge, maxAge);
        }

        System.out.println("Candidates found: " + candidates.size());

        List<User> matchingUsers = candidates.stream()
                .filter(user -> !user.getEmail().equals(selectoption.email))
                .filter(user -> {
                    String interest = user.getInterest();
                    int commonInterests = 0;
                    Integer age1 = user.getAge();
                    System.out.println("Current user age: " + age1);
                    System.out.println("Comparing interests: " + currentUserInterest + " and " + interest);
                    for (int i = 0; i < interest.length(); i++) {
                        if (currentUserInterest.charAt(i) == '1' && interest.charAt(i) == '1') {
                            commonInterests++;
                        }
                    }
                    System.out.println("Common interests: " + commonInterests);
                    return commonInterests >= 2;
                })
                .collect(Collectors.toList());

        System.out.println("Matching users found: " + matchingUsers.size());
        return matchingUsers;
    }
}
