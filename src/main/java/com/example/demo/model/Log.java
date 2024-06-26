package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "log")
@IdClass(LogId.class)
public class Log {
  
  @Id
  @Column(name = "usr_id")
  private String usrId;
  
  @Id
  @Column(name = "time", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
  private LocalDateTime time;
  
  @Column(name = "log_text")
  private String logText;
  
  // Getters and setters
  public String getUsrId() {
    return usrId;
  }
  
  public void setUsrId(String usrId) {
    this.usrId = usrId;
  }
  
  public LocalDateTime getTime() {
    return time;
  }
  
  public void setTime(LocalDateTime time) {
    this.time = time;
  }
  
  public String getLogText() {
    return logText;
  }
  
  public void setLogText(String logText) {
    this.logText = logText;
  }
}
