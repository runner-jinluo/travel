package com.example.demo.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class LogId implements Serializable {
  private String usrId;
  private LocalDateTime time;
  
  // Default constructor
  public LogId() {}
  
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
  
  // hashCode and equals
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    LogId logId = (LogId) o;
    return Objects.equals(usrId, logId.usrId) && Objects.equals(time, logId.time);
  }
  
  @Override
  public int hashCode() {
    return Objects.hash(usrId, time);
  }
}
