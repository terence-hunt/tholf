/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tholf.player;

import java.sql.SQLException;

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
        
        dao = new HumanPlayerDaoImpl();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) throws SQLException {
        this.username = username;
        dao.updatePlayer(this);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) throws SQLException {
        this.address = address;
        dao.updatePlayer(this);
    }

    public double getHandicap() {
        return handicap;
    }

    public void setHandicap(double handicap) throws SQLException {
        this.handicap = handicap;
        dao.updatePlayer(this);
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) throws SQLException {
        this.sex = sex;
        dao.updatePlayer(this);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
