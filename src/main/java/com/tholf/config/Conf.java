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
    GENERAL("conf/general.properties","/path/to/defualt/general.properties.that can be overriden by user"),
    PLAYER("conf/player.properties", "/path/to/defualt/player.properties.that can be overriden by user"),
    COURSE("conf/course.properties", "/path/to/defualt/course.properties.that can be overriden by user"),
    SCORING("conf/scoring.properties", "/path/to/defualt/scoring.properties.that can be overriden by user"); // This will be part of the build

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
    
    public String get(String key){
        return defaultProps.getProperty(key);
    }

}
