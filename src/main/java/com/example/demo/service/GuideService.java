package com.example.demo.service;

import com.example.demo.model.Guide;
import java.util.List;

public interface GuideService {
  Guide saveGuide(Guide guide);
  List<Guide> getAllGuides();
}
