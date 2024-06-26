package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "route")
public class Route {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  
  @Column(name = "route", unique = true)
  private String route;
  
  // Getters and setters
  public Integer getId() {
    return id;
  }
  
  public void setId(Integer id) {
    this.id = id;
  }
  
  public String getRoute() {
    return route;
  }
  
  public void setRoute(String route) {
    this.route = route;
  }
}
