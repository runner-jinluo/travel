package com.example.demo.controller;

import com.example.demo.dto.GuideResponse;
import com.example.demo.model.Guide;
import com.example.demo.model.Route;
import com.example.demo.service.GuideService;
import com.example.demo.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/guides")
public class GuideController {
  
  @Autowired
  private GuideService guideService;
  
  @Autowired
  private RouteService routeService;
  
  @PostMapping("/upload")
  public Guide uploadGuide(@RequestBody Guide guide) {
    return guideService.saveGuide(guide);
  }
  
  @GetMapping("/all")
  public List<GuideResponse> getAllGuides() {
    List<Guide> guides = guideService.getAllGuides();
    List<Route> routes = routeService.getAllRoutes();
    
    return guides.stream().map(guide -> {
      Route route = routes.stream().filter(r -> r.getId().equals(guide.getRouteId())).findFirst().orElse(null);
      return new GuideResponse(guide, route);
    }).collect(Collectors.toList());
  }
}
