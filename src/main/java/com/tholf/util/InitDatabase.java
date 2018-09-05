/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tholf.util;

import com.tholf.ds.TholfDs;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thunt
 */
public class InitDatabase implements Runnable{

    private static final Logger LOG = Logger.getLogger(InitDatabase.class.getName());
    private static final String playersTableSchema = "";
    private static final String robotsTableSchema = "";
    TholfDs ds;
    
    public InitDatabase(){
        ds = new TholfDs(); 
    }

    @Override
    public void run() {
        try {
            LOG.log(Level.FINE,"Testing database connection");
            DatabaseMetaData md = ds.getMetaData();
            ResultSet rs = md.getTables(null, null, robotsTableSchema, null);
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
}
