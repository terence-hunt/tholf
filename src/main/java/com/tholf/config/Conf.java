/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tholf.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thunt
 * Based on https://www.baeldung.com/java-properties
 */
public enum Conf {
    GENERAL("conf/general.properties","/etc/defaults/wildfly/general.properties"),
    PLAYER("conf/player.properties", "/etc/defaults/wildfly/player.properties"),
    COURSE("conf/course.properties", "/etc/defaults/wildfly/course.properties"),
    SCORING("conf/scoring.properties", "/etc/defaults/wildfly/scoring.properties"); 

    private static final Logger LOG = Logger.getLogger(Conf.class.getName());
    Properties defaultProps;
    
    Conf(String properties, String overrideProperties) {
        FileInputStream in = null;
        try {
            //read config file
            defaultProps = new Properties();
            in = new FileInputStream(properties);
            defaultProps.load(in);
            in.close();
            // create application properties with default
            Properties applicationProps = new Properties(defaultProps);
            // now load properties 
            // from last invocation
            in = new FileInputStream(overrideProperties);
            applicationProps.load(in);
            in.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Conf.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Conf.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                in.close();
            } catch (IOException ex) {
                Logger.getLogger(Conf.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    /**
     * Will return the value if it is in default props, it does not
     * exist it will return the default
     * @param key the key being looked up
     * @param def this will be returned if the value for the key does 
     * not exist.
     * 
     */
    public String get(String key, String def){
        String value = def;
        if(defaultProps.contains(key)){
            value = defaultProps.getProperty(key);
        }
        return value;
    }

}
