package com.example.demo.repository;

import com.example.demo.model.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Attraction;
import java.util.List;

public interface AttractionRepository extends JpaRepository<Attraction, Long> {
    List<Attraction> findByUserId(String userId);
}
