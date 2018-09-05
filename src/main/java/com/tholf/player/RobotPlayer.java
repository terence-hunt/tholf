/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tholf.player;

import com.tholf.config.Conf;
import com.tholf.config.PlayerKeys;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

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
    }
    


    public String genUpdateString() {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("name", name);
        map.put("skillLevel", String.valueOf(skillLevel));
 
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE ");
        sb.append(Conf.PLAYER.getString(PlayerKeys.robotTable));
        sb.append(" set ");

        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            sb.append(pair.getKey());
            sb.append(" = '");
            sb.append(pair.getValue());
            sb.append("' ");
            it.remove();
        }
        sb.append("WHERE uid = '");
        sb.append(uid);
        sb.append("'");

        return sb.toString();
    }

}
