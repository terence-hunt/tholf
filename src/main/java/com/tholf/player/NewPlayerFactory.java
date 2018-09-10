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

    String username;
    String name;
    double handicap;
    String address;
    String sex;
    String email;
    String tee;

    public NewPlayerFactory(String username, String name, double handicap, String address, String sex, String email, String tee) {
        this.username = username;
        this.name = name;
        this.handicap = handicap;
        this.address = address;
        this.sex = sex;
        this.email = email;
        this.tee = tee;
    }

    @Override
    public Player create() {
        //Check if user with that name already exists in the database
        Player p = PlayerFactoryMgr.getPlayerFactory(username).create();
        if (p != null) {
            return p;
        }

        return new HumanPlayer(username, name, address, handicap, sex, email, tee);
    }

}
