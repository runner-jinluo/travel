package com.example.demo.controller;

import com.example.demo.model.Log;
import com.example.demo.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/logs")
public class LogController {
  
  @Autowired
  private LogService logService;
  
  @PostMapping("/upload")
  public Log uploadLog(@RequestBody Log log) {
    return logService.saveLog(log);
  }
  
  @GetMapping("/all")
  public List<Log> getAllLogs() {
    return logService.getAllLogs();
  }
  
}
