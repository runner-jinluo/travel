package com.example.demo.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class Point {
    private double lng;
    private double lat;

    // Getters and Setters
    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }
}
