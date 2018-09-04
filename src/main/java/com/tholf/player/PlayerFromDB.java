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

    public String id;

    public PlayerFromDB(String id) {
        this.id = id;
    }

    public Player create() {
        //Is the id the userid or the username.
        return new HumanPlayer();
        
    }

}
