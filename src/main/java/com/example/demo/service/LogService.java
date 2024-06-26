package com.example.demo.service;

import com.example.demo.model.Log;

import java.util.List;

public interface LogService {
  Log saveLog(Log log);
  List<Log> getAllLogs();
}
