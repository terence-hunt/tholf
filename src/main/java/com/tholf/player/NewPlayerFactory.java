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
public class NewPlayerFactory implements PlayerFactory {
    String name;
    double handicap;
    String address;
    String sex;
    
    public NewPlayerFactory(String username, String name, double handicap, String address, String sex){
        this.name = name;
        this.handicap = handicap;
        this.address = address;
        this.sex = sex;
    }

    @Override
    public Player create() {
        // create a new player object, add it to the database
        return new HumanPlayer();
    }
    
}
