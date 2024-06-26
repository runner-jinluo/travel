package com.example.demo.service.impl;

import com.example.demo.model.Guide;
import com.example.demo.repository.GuideRepository;
import com.example.demo.service.GuideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuideServiceImpl implements GuideService {
  
  @Autowired
  private GuideRepository guideRepository;
  
  @Override
  public Guide saveGuide(Guide guide) {
    return guideRepository.save(guide);
  }
  
  @Override
  public List<Guide> getAllGuides() {
    return guideRepository.findAll();
  }
}
