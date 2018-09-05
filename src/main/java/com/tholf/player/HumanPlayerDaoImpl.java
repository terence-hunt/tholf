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
public class HumanPlayerDaoImpl implements PlayerDao<HumanPlayer> {

    private static final String playerTableSQL
            = "SELECT uid,username,name,address,handicap,sex,email from " + Conf.PLAYER.getString(PlayerKeys.playerTable);
    TholfDs ds = new TholfDs();

    @Override
    public void updatePlayer(HumanPlayer p) throws SQLException {
        HashMap<String, String> map = new HashMap<>();
        map.put("name", p.getName());
        map.put("address", p.getAddress());
        map.put("handicap", String.valueOf(p.getHandicap()));
        map.put("sex", p.getSex());
        map.put("email", p.getEmail());

        StringBuilder sb = new StringBuilder("UPDATE ");
        sb.append(Conf.PLAYER.getString(PlayerKeys.playerTable));
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
    public void deletePlayer(HumanPlayer p) throws SQLException {
        StringBuilder sb = new StringBuilder("DELETE from ");
        sb.append(Conf.PLAYER.getString(PlayerKeys.playerTable));
        sb.append(" WHERE uid = '");
        sb.append(p.getUid());
        sb.append("'");

        ds.executeUpdate(sb.toString());
    }

    @Override
    public Player getPlayer(String uid) throws SQLException {
        StringBuilder sb = new StringBuilder(playerTableSQL);
        sb.append(" WHERE uid = '");
        sb.append(uid);
        sb.append("'");
        ResultSet rs = ds.executeQuery(sb.toString());
        return buildPlayer(rs);
    }

    @Override
    public List<HumanPlayer> getAllPlayers() throws SQLException {
        StringBuilder sb = new StringBuilder(playerTableSQL);
        sb.append(PlayerKeys.playerTable);

        ResultSet rs = ds.executeQuery(sb.toString());

        List<HumanPlayer> l = new ArrayList<>();

        while (rs.next()) {
            l.add(buildPlayer(rs));
        }
        return l;
    }

    private HumanPlayer buildPlayer(ResultSet rs) throws SQLException {
        String uid = rs.getString(0);
        String username = rs.getString(1);
        String name = rs.getString(2);
        String address = rs.getString(3);
        double handicap = rs.getDouble(4);
        String sex = rs.getString(5);
        String email = rs.getString(6);

        return new HumanPlayer(uid, username, name, address, handicap, sex, email);
    }

}
