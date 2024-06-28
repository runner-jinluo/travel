package com.example.demo.service;

import com.example.demo.model.Log;
import com.example.demo.repository.LogRepository;
import com.example.demo.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogServiceImpl implements LogService {
  
  @Autowired
  private LogRepository logRepository;
  
  @Override
  public Log saveLog(Log log) {
    return logRepository.save(log);
  }
  
  @Override
  public List<Log> getAllLogs() {
    return logRepository.findAll();
  }
}
