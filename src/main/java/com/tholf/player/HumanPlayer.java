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
public class HumanPlayer extends Player {

    String username;
    String address;
    double handicap;
    String sex;
    String email;

    public HumanPlayer(String username, String name, String address, double handicap, String sex, String email) {
        this(null, username, name, address, handicap, sex, email);
    }

    public HumanPlayer(String uid, String username, String name, String address, double handicap, String sex, String email) {
        this.uid = uid;
        if (this.uid == null) {
            generateUid();
        }
        this.name = name;
        this.address = address;
        this.handicap = handicap;
        this.sex = sex;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
        PlayerMgr.updatePlayer(this);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
        PlayerMgr.updatePlayer(this);
    }

    public double getHandicap() {
        return handicap;
    }

    public void setHandicap(double handicap) {
        this.handicap = handicap;
        PlayerMgr.updatePlayer(this);
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
        PlayerMgr.updatePlayer(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        PlayerMgr.updatePlayer(this);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
