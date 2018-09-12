/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tholf.player.dao;

import com.tholf.ds.TholfDs;

/**
 *
 * @author thunt
 */
public abstract class Dao {
    String SQL;
    TholfDs ds;
    
    Dao(){
        ds = new TholfDs();
    }

    String getSQL() {
        return SQL;
    }

    final void setSQL(String SQL) {
        this.SQL = SQL;
    }
    
}
