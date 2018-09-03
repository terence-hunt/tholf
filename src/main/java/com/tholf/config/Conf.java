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
    DEFAULT("/path/to/defualt/config"); // This will be part of the build
    //this will be on the file system avalile to people that need to change settings. 
    //this will be on the file system avalile to people that need to change settings.
    private static final Logger LOG = Logger.getLogger(Conf.class.getName());
    
    
    Conf(String filePath) {
        FileInputStream in = null;
        try {
            //read config file
            Properties defaultProps = new Properties();
            in = new FileInputStream(filePath);
            defaultProps.load(in);
            in.close();
            // create application properties with default
            Properties applicationProps = new Properties(defaultProps);
            // now load properties 
            // from last invocation
            in = new FileInputStream("appProperties");
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

}
