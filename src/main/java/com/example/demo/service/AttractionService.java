package com.example.demo.service;

import com.example.demo.model.Attraction;
import com.example.demo.repository.AttractionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttractionService {

    @Autowired
    private AttractionRepository attractionRepository;

    public List<Attraction> getAttractions(String userId) {
        return attractionRepository.findByUserId(userId);
    }

    public void deleteAttractions(List<Long> ids) {
        attractionRepository.deleteAllById(ids);
    }

    public List<Attraction> saveAttractions(List<Attraction> attractions) {
        return attractionRepository.saveAll(attractions);
    }

}
