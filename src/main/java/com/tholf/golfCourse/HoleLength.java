/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tholf.golfCourse;

import com.tholf.config.Conf;
import com.tholf.config.GeneralKeys;
import com.tholf.config.GeneralKeys.DistanceUnits;

/**
 *
 * @author thunt
 */
public class HoleLength {
    int yardage;
    DistanceUnits distanceUnit = DistanceUnits.valueOf(Conf.GENERAL.getString(GeneralKeys.distanceUnit));
    public static final double Y2M = 0.9144;
    
    public int getHoleLength(){        
        if(distanceUnit.equals(DistanceUnits.YARDS)){
            return yardage;
        }
        else if(distanceUnit.equals(DistanceUnits.METERS)){
            return (int)(Math.round(yardage * Y2M));
        }
        else{
            throw new IllegalArgumentException("Unit " + distanceUnit.toString() + " unknown");
        }
    }

    public void setYardage(int yardage) {
        this.yardage = yardage;
    }
    
    public void setMeterage(int meterage){
        this.yardage = (int) Math.round(meterage / Y2M);
    }

    public void setDistanceUnit(DistanceUnits distanceUnit) {
        this.distanceUnit = distanceUnit;
    }

    public DistanceUnits getDistanceUnit() {
        return distanceUnit;
    }
}
