package com.example.demo.controller;

import com.example.demo.model.AttractionRequest;
import com.example.demo.model.Attraction;
import com.example.demo.service.AttractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.slf4j.LoggerFactory;

import static com.mysql.cj.conf.PropertyKey.logger;

@RestController
@RequestMapping("/api/attractions")
public class AttractionController {
    Map<String, String> response = new HashMap<>();

    @Autowired
    private AttractionService attractionService;


    @PostMapping("/save_more_data")
    public List<Attraction> saveAttractions(@RequestBody AttractionRequest request) {
        List<Attraction> attractions = request.getAttractions();
        String userid = request.getUserid();
        for (Attraction attraction : attractions) {
            attraction.setUserId(userid);
        }
        return attractionService.saveAttractions(attractions);
    }

    @PostMapping("/get_data")
    public List<Attraction> getAttractions(@RequestBody Map<String, String> payload) {
        String userid = payload.get("userid");
        return attractionService.getAttractions(userid);
    }
    @PostMapping("/del")
    public ResponseEntity<?> deleteAttractions(@RequestBody AttractionRequest request) {
        Map<String, Object> response = new HashMap<>();
        List<Attraction> attractions = request.getAttractions();
        String userId = request.getUserid();

        try {
            for (Attraction attraction : attractions) {
                attractionService.deleteById(attraction.getId());
            }
            response.put("status", "y");
        } catch (Exception e) {
            response.put("status", "n");
            response.put("error", e.getMessage());
            return ResponseEntity.status(500).body(response);
        }

        return ResponseEntity.ok(response);
    }
}
