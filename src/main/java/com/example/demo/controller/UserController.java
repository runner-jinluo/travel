package com.example.demo.controller;

import com.example.demo.dto.MatchingUserResponse;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;
    
    private static final String[] INTERESTS = {
        "徒步旅行", "文化探索", "美食之旅", "冒险运动", "海滩度假", "城市探险", "自驾游", "摄影"
    };
    
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

    @PutMapping("/update/{id}")
    public User updateUser(@PathVariable String id, @RequestBody User userDetails) {
        return userService.updateUser(id, userDetails);
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
    
    @GetMapping("/matching")
    public List<MatchingUserResponse> getMatchingUsers(@RequestParam String email) {
        List<User> matchingUsers = userService.findMatchingUsers(email);
        System.out.println("Matching users response: " + matchingUsers.size());
        return matchingUsers.stream()
            .map(user -> {
                StringBuilder commonInterests = new StringBuilder();
                String interest = user.getInterest();
                for (int i = 0; i < interest.length(); i++) {
                    if (interest.charAt(i) == '1') {
                        if (commonInterests.length() > 0) {
                            commonInterests.append("、");
                        }
                        commonInterests.append(INTERESTS[i]);
                    }
                }
                return new MatchingUserResponse(user.getName(), user.getAge(), user.getPhoneNumber(), commonInterests.toString());
            })
            .collect(Collectors.toList());
    }
    
    
}
