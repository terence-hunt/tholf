/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tholf.player;

/**
 *
 * @author thunt
 */
public class PlayerFactoryMgr {
    public static PlayerFactory getPlayerFactory(String uid){
        return new PlayerFromDB(uid);
    }
    
}
