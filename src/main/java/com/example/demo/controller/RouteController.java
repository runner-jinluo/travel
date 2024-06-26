package com.example.demo.controller;

import com.example.demo.model.Route;
import com.example.demo.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/routes")
public class RouteController {
  
  @Autowired
  private RouteService routeService;
  
  @GetMapping("/all")
  public List<Route> getAllRoutes() {
    return routeService.getAllRoutes();
  }
}
