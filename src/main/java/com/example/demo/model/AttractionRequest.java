package com.example.demo.model;

import com.example.demo.model.Attraction;
import jakarta.persistence.Entity;

import java.util.List;

public class AttractionRequest {
    private String userid;
    private List<Attraction> attractions;

    // Getters and Setters
    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public List<Attraction> getAttractions() {
        return attractions;
    }

    public void setAttractions(List<Attraction> attractions) {
        this.attractions = attractions;
    }
}
