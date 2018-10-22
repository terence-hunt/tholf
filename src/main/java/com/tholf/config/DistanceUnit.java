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
public enum DistanceUnit {
    
    YARDS("Yards","yrds", "yd", 0.9144d),
    METERS("Meters", "mtrs","m",1d),
    FEET("Feet", "ft", "ft", 0.3048),
    CENTIMETERS("Centimeters","cm","cm",0.01);
    ;
    
    private String longName;
    private String shortName;
    private String unit;
    private double conversionToMeters;
    
    private DistanceUnit(String longName, String shortName, String unit, Double conversionToMeters){
        this.longName = longName;
        this.shortName = shortName;
        this.unit = unit;
        this.conversionToMeters = conversionToMeters;
    }
    
    public String getLongName(){
        return longName;
    }
    public String getShortName(){
        return shortName;
    }
    public String getUnit(){
        return unit;
    }
    public Double getConversion(){
        return conversionToMeters;
    }
    public Double convertToMeters(Double dist){
        return conversionToMeters * dist;
    }
    
    public Double convertFromMeters(Double dist){
        return dist / dist.getConversion();
    }
    
}
