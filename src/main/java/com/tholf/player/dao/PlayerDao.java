/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tholf.player.dao;

import com.tholf.player.*;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author thunt
 * @param <T>
 */
public interface PlayerDao<T extends Player> 
 {
    void updatePlayer(T p) throws SQLException;
    void deletePlayer(T p) throws SQLException;
    Player getPlayer(String uid) throws SQLException;
    List<T> getAllPlayers() throws SQLException;

}
