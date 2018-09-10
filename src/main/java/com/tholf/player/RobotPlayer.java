/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tholf.player;

import com.tholf.player.dao.RobotPlayerDao;
import java.sql.SQLException;

/**
 *
 * @author thunt
 */
public class RobotPlayer extends Player {
    Double skillLevel;
    
    public RobotPlayer(String name, double skillLevel){
        this(null, name, skillLevel);
    }
    
    public RobotPlayer(String uid, String name, double skillLevel){
        this.uid = uid;
        if(this.uid == null){
            generateUid();
        }
        this.name = name;
        this.skillLevel = skillLevel;
        
        dao = new RobotPlayerDao();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws SQLException {
        this.name = name;
        dao.updatePlayer(this);
    }

    public Double getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(Double skillLevel) throws SQLException {
        this.skillLevel = skillLevel;
        dao.updatePlayer(this);
    }
    
}
