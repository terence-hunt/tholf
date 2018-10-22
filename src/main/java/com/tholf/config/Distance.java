/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tholf.config;

/**
 *
 * @author thunt
 */
public class Distance {
    
    private double meters;
    DistanceUnit unit;
    
    public Distance(Double dist, DistanceUnit unit){
        this.meters = unit.convertToMeters(dist);
        this.unit = unit;
    }
    
    public Double getDistance(DistanceUnit unit){
        return meters / 
    }
    
}
