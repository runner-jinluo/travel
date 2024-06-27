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

  // 默认构造函数
  public Log() {
    this.time = LocalDateTime.now();
  }

  // Getter 和 Setter 方法
  public String getUsrId() {
    return usrId;
  }

  // 删除 usrId 的 setter 方法以防止修改
  // public void setUsrId(String usrId) {
  //     this.usrId = usrId;
  // }

  public LocalDateTime getTime() {
    return time;
  }

  // 删除 time 的 setter 方法以防止修改
  // public void setTime(LocalDateTime time) {
  //     this.time = time;
  // }

  public String getLogText() {
    return logText;
  }

  public void setLogText(String logText) {
    this.logText = logText;
  }
}
