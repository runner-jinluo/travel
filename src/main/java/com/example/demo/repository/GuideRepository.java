package com.example.demo.repository;

import com.example.demo.model.Guide;
import com.example.demo.model.GuideId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuideRepository extends JpaRepository<Guide, GuideId> {
}