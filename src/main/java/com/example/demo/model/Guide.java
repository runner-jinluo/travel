package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "guide")
@IdClass(GuideId.class)
public class Guide {
  
  @Id
  @Column(name = "usr_id")
  private String usrId;
  
  @Id
  @Column(name = "time", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
  private LocalDateTime time;
  
  @Column(name = "guide_text")
  private String guideText;
  
  @Column(name = "route_id")
  private Integer routeId;

  public Guide() {
    this.time = LocalDateTime.now();
  }
  // Getters and setters
  public String getUsrId() {
    return usrId;
  }
  
  public void setUsrId(String usrId) {
    this.usrId = usrId;
  }
  
  /*public LocalDateTime getTime() {
    return time;
  }
  
  public void setTime(LocalDateTime time) {
    this.time = time;
  }*/
  
  public String getGuideText() {
    return guideText;
  }
  
  public void setGuideText(String guideText) {
    this.guideText = guideText;
  }
  
  public Integer getRouteId() {
    return routeId;
  }
  
  public void setRouteId(Integer routeId) {
    this.routeId = routeId;
  }
}
