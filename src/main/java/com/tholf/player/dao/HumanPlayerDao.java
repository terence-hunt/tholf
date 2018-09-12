/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tholf.player.dao;

import com.tholf.config.Conf;
import com.tholf.config.PlayerKeys;
import com.tholf.player.HumanPlayer;
import com.tholf.player.Player;
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
public class HumanPlayerDao extends Dao implements PlayerDao<HumanPlayer> {

    private static final HashMap<String, Integer> COLUMNS = new HashMap();
    private static final String TABLE;

    static {
        COLUMNS.put("player_id", 0);
        COLUMNS.put("username", 1);
        COLUMNS.put("name", 2);
        COLUMNS.put("address", 3);
        COLUMNS.put("handicap", 4);
        COLUMNS.put("sex", 5);
        COLUMNS.put("email", 6);
        COLUMNS.put("tee", 7);
        TABLE = Conf.PLAYER.getString(PlayerKeys.playerTable);
    }

    public HumanPlayerDao() {
        super();
        StringBuilder sb = new StringBuilder("SELECT ");
        Iterator<String> it = COLUMNS.keySet().iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            sb.append(",");
        }
        sb.append(" from ");
        sb.append(TABLE);
        setSQL(sb.toString());
    }

    @Override
    public void updatePlayer(HumanPlayer p) throws SQLException {
        HashMap<String, String> map = new HashMap<>();
        map.put("name", p.getName());
        map.put("address", p.getAddress());
        map.put("handicap", String.valueOf(p.getHandicap()));
        map.put("sex", p.getSex());
        map.put("email", p.getEmail());

        StringBuilder sb = new StringBuilder("UPDATE ");
        sb.append(TABLE);
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
        sb.append(TABLE);
        sb.append(" WHERE uid = '");
        sb.append(p.getUid());
        sb.append("'");

        ds.executeUpdate(sb.toString());
    }

    @Override
    public Player getPlayer(String uid) throws SQLException {
        StringBuilder sb = new StringBuilder(SQL);
        sb.append(" WHERE uid = '");
        sb.append(uid);
        sb.append("'");
        ResultSet rs = ds.executeQuery(sb.toString());
        if (rs.first()) {
            return buildPlayer(rs);
        } else {
            return null;
        }
    }

    @Override
    public List<HumanPlayer> getAllPlayers() throws SQLException {
        StringBuilder sb = new StringBuilder(SQL);
        sb.append(PlayerKeys.playerTable);

        ResultSet rs = ds.executeQuery(sb.toString());

        List<HumanPlayer> l = new ArrayList<>();

        while (rs.next()) {
            l.add(buildPlayer(rs));
        }
        return l;
    }

    private HumanPlayer buildPlayer(ResultSet rs) throws SQLException {
        String uid = rs.getString(COLUMNS.get("player_id"));
        String username = rs.getString(COLUMNS.get("username"));
        String name = rs.getString(COLUMNS.get("name"));
        String address = rs.getString(COLUMNS.get("address"));
        double handicap = rs.getDouble(COLUMNS.get("handicap"));
        String sex = rs.getString(COLUMNS.get("sex"));
        String email = rs.getString(COLUMNS.get("email"));
        String tee = rs.getString(COLUMNS.get("tee"));

        return new HumanPlayer(uid, username, name, address, handicap, sex, email, tee);
    }

}
