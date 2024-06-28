package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.*;
@Entity
@Table(name = " scenic_spot")

public class Scenic_Spot {
    @Id
    @Column(name = "name")
    private String name;

    @Column(name = "locate_x")
    private double locate_x;

    @Column(name = "locate_y")
    private double locate_y;

    @Column(name = "classification")
    private String  classification;

    @Column(name = "during")
    private String  during;

    @Column(name = "price")
    private String  price;

    // Getters and Setters

    public double getLocate_y() {
        return locate_y;
    }

    public void setLocate_y(double locate_y) {
        this.locate_y = locate_y;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLocate_x() {
        return locate_x;
    }

    public void setLocate_x(double locate_x) {
        this.locate_x = locate_x;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getDuring() {
        return during;
    }

    public void setDuring(String during) {
        this.during = during;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }






}
