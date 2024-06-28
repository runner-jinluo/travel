package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByEmail(String email);
    List<User> findByAgeBetweenAndSex(Integer minAge, Integer maxAge, String sex);
    List<User> findByAgeBetween(Integer minAge, Integer maxAge);
}
