/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tholf.player;

import com.tholf.config.Conf;
import com.tholf.config.PlayerKeys;
import com.tholf.player.dao.PlayerDao;
import com.tholf.util.UID;
import com.tholf.util.UidGenerator;
import java.sql.SQLException;

/**
 *
 * @author thunt
 */
public abstract class Player implements UID {

    private static final String prefix = Conf.PLAYER.getString(PlayerKeys.prefix);

    String uid;
    String name;
    PlayerDao dao;

    protected final void generateUid() {
        if (uid == null) {
            uid = UidGenerator.generateUid(prefix);
        }
    }

    @Override
    public String getUid() {
        return uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws SQLException {
        this.name = name;
        dao.updatePlayer(this);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Player)) {
            return false;
        }
        if (((Player) o).getUid().equals(this.getUid())) {
            return true;
        }
        return false;
    }

    public void deletePlayer() throws SQLException {
        dao.deletePlayer(this);
    }

}
