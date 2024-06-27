package com.example.demo.dto;

public class MatchingUserResponse {
  private String name;
  private Integer age;
  private Long phoneNumber;
  private String commonInterests;
  
  public MatchingUserResponse(String name, Integer age, Long phoneNumber, String commonInterests) {
    this.name = name;
    this.age = age;
    this.phoneNumber = phoneNumber;
    this.commonInterests = commonInterests;
  }
  
  // Getters and setters
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public Integer getAge() {
    return age;
  }
  
  public void setAge(Integer age) {
    this.age = age;
  }
  
  public Long getPhoneNumber() {
    return phoneNumber;
  }
  
  public void setPhoneNumber(Long phoneNumber) {
    this.phoneNumber = phoneNumber;
  }
  
  public String getCommonInterests() {
    return commonInterests;
  }
  
  public void setCommonInterests(String commonInterests) {
    this.commonInterests = commonInterests;
  }
}
