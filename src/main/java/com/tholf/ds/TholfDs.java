/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tholf.ds;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 *
 * @author thunt
 */
public class TholfDs {

    private static final Logger LOG = Logger.getLogger(TholfDs.class.getName());

    @Resource(mappedName = "java:jboss/datasources/tholfDS")
    private DataSource ds;

    public void executeUpdate(String sql) throws SQLException {
        LOG.log(Level.FINEST, "Running SQL update: {0}", sql);
        PreparedStatement stmt = execute(sql);
        stmt.executeUpdate();
    }

    public ResultSet executeQuery(String sql) throws SQLException {
        LOG.log(Level.FINEST, "Running SQL query: {0}", sql);
        PreparedStatement stmt = execute(sql);
        return stmt.executeQuery();
    }

    private PreparedStatement execute(String sql) throws SQLException {
        try (Connection conn = ds.getConnection()) {
            conn.setAutoCommit(false);
            return conn.prepareStatement(sql);
        }
    }
    
    public DatabaseMetaData getMetaData() throws SQLException{
        try (Connection conn = ds.getConnection()) {
            conn.setAutoCommit(false);
            return conn.getMetaData();
        }
    }
}
