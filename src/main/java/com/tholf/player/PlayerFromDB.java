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
public class PlayerFromDB implements PlayerFactory {

    public String uid;

    public PlayerFromDB(String uid) {
        this.uid = uid;
    }

    public Player create() {
        //Lookup uid in the database and create the player object from that
        return new HumanPlayer();
        
    }

}
