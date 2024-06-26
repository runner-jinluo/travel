package com.example.demo.service.impl;

import com.example.demo.model.Route;
import com.example.demo.repository.RouteRepository;
import com.example.demo.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteServiceImpl implements RouteService {
  
  @Autowired
  private RouteRepository routeRepository;
  
  @Override
  public List<Route> getAllRoutes() {
    return routeRepository.findAll();
  }
}