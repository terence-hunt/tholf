/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tholf.player;

import com.tholf.config.Conf;
import com.tholf.config.PlayerKeys;
import com.tholf.ds.TholfDs;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 *
 * @author thunt
 */
public class RobotPlayerDaoImpl implements PlayerDao<RobotPlayer> {

    private static final String robotTableSQL
            = "SELECT uid,name,skillLevel from " + Conf.PLAYER.getString(PlayerKeys.robotTable);
    TholfDs ds = new TholfDs();

    @Override
    public void updatePlayer(RobotPlayer p) throws SQLException {
        HashMap<String, String> map = new HashMap<>();
        map.put("name", p.getName());
        map.put("skillLevel", String.valueOf(p.getSkillLevel()));

        StringBuilder sb = new StringBuilder("UPDATE ");
        sb.append(Conf.PLAYER.getString(PlayerKeys.robotTable));
        sb.append(" set ");

        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            sb.append(pair.getKey());
            sb.append(" = '");
            sb.append(pair.getValue());
            sb.append("' ");
            it.remove();
        }
        sb.append("WHERE uid = '");
        sb.append(p.getUid());
        sb.append("'");

        ds.executeUpdate(sb.toString());
    }

    @Override
    public void deletePlayer(RobotPlayer p) throws SQLException {
        StringBuilder sb = new StringBuilder("DELETE from ");
        sb.append(Conf.PLAYER.getString(PlayerKeys.robotTable));
        sb.append(" WHERE uid = '");
        sb.append(p.getUid());
        sb.append("'");

        ds.executeUpdate(sb.toString());
    }

    @Override
    public Player getPlayer(String uid) throws SQLException {
        StringBuilder sb = new StringBuilder(robotTableSQL);
        sb.append(" WHERE uid = '");
        sb.append(uid);
        sb.append("'");
        ResultSet rs = ds.executeQuery(sb.toString());
        return buildPlayer(rs);
    }

    @Override
    public List<RobotPlayer> getAllPlayers() throws SQLException {
        StringBuilder sb = new StringBuilder(robotTableSQL);
        sb.append(PlayerKeys.playerTable);
        ResultSet rs = ds.executeQuery(sb.toString());
        List<RobotPlayer> l = new ArrayList<>();
        while (rs.next()) {
            l.add(buildPlayer(rs));
        }
        return l;
    }

    private RobotPlayer buildPlayer(ResultSet rs) throws SQLException {
        String uid = rs.getString(0);
        String name = rs.getString(1);
        double skillLevel = rs.getDouble(2);

        return new RobotPlayer(uid, name, skillLevel);
    }

}
