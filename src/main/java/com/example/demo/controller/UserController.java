package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable String id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

   /* @PutMapping("/update")
    public User updateUser(@RequestBody User userDetails) {
        logger.info("Update request received with user details: {}", userDetails);
        if (userDetails.getEmail() == null) {
            logger.error("Email is null in the request body");
        }
        return userService.updateUser(userDetails.getEmail(), userDetails);
    }*/
   @PutMapping("/update")
   public ResponseEntity<?> updateUser(@RequestBody updateUserRequest updateUserRequest) {
       logger.info("Update request received with user details: {}", updateUserRequest.email);

       if (updateUserRequest.email == null) {
           logger.error("Email is null in the request body");
           return ResponseEntity.badRequest().body("Email cannot be null");
       }
       User user = new User();
       user.setEmail(updateUserRequest.email);
       user.setAge(updateUserRequest.age);
       user.setName(updateUserRequest.name);
       user.setPhoneNumber(updateUserRequest.phoneNumber);
       user.setSex(updateUserRequest.sex);
       user.setInterest(updateUserRequest.interest);
       logger.info("Update request received with user details: {}", updateUserRequest.interest);
       logger.info("Update request received with user details: {}", user.getInterest());
       try {
           User updatedUser = userService.updateUser(updateUserRequest.email, user);
           return ResponseEntity.ok(updatedUser);
       } catch (Exception e) {
           logger.error("Error updating user: {}", e.getMessage());
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating user");
       }
   }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
    }

    @PostMapping("/login")
    public User loginUser(@RequestBody LoginRequest loginRequest) {
        // 记录接收到的登录请求
        logger.info("Login request received with email: {}", loginRequest.getEmail());

        User user = userService.loginUser(loginRequest.getEmail(), loginRequest.getPassword());

        // 记录登录处理结果
        logger.info("Login response: {}", user != null ? "User found" : "User not found");

        return user;

    }
    public static class updateUserRequest {
       public String email;
       public int age;
       public String name;
       public long phoneNumber;
       public String sex;
       public String interest;
    }
    public static class LoginRequest {
        private String email;
        private String password;

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}
