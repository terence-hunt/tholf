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

    public String id; //can be uid or username

    public PlayerFromDB(String id) {
        this.id = id;
    }

    public Player create() {
        /*Is the id the userid or the username.
        select * from players where uid = 'uid';
        if result is returned then construct the user from the rows in that table
        if nothing is returned try 
        select * from players where username = 'uid'
        if result is returned then construct the user from the rows in that table
        if nothing is returned throw an error. */
        String uid = null;
        String username = null;
        String name = null;
        double handicap = 0d;
        String sex = null;
        String email = null;
        String tee = null;
        
        return new HumanPlayer(uid, username, name, handicap, sex, email, tee);
        
    }

}
