/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tholf.player;

import com.tholf.config.Conf;
import com.tholf.util.UID;
import com.tholf.util.UidGenerator;

/**
 *
 * @author thunt
 */
public class Player implements UID {
    private String UID;
    private static final String prefix = Conf.PLAYER.get("prefix");
    
    public Player(){
        UidGenerator.generateUid(prefix);
    }

    @Override
    public String getUID() {
        return UID;
    }
    
}
