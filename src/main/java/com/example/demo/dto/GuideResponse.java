package com.example.demo.dto;

import com.example.demo.model.Guide;
import com.example.demo.model.Route;

public class GuideResponse {
  private Guide guide;
  private Route route;
  
  public GuideResponse(Guide guide, Route route) {
    this.guide = guide;
    this.route = route;
  }
  
  // Getters and setters
  public Guide getGuide() {
    return guide;
  }
  
  public void setGuide(Guide guide) {
    this.guide = guide;
  }
  
  public Route getRoute() {
    return route;
  }
  
  public void setRoute(Route route) {
    this.route = route;
  }
}
