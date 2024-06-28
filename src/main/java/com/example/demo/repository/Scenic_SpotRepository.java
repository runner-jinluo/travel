package com.example.demo.repository;

import com.example.demo.model.Scenic_Spot;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.List;

public interface Scenic_SpotRepository extends JpaRepository<Scenic_Spot, String> {

}
