package com.example.demo.controller;

import com.example.demo.model.AttractionRequest;
import com.example.demo.model.Attraction;
import com.example.demo.service.AttractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/attractions")
public class AttractionController {

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
    public void deleteAttractions(@RequestBody List<Long> ids) {
        attractionService.deleteAttractions(ids);
    }
}
