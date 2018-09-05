/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tholf.test;
import com.tholf.player.Player;
import com.tholf.player.PlayerFactory;
import com.tholf.player.PlayerFactoryMgr;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
        
/**
 *
 * @author thunt
 */
public class TestServletContextListener implements ServletContextListener{

    private static final Logger LOG = Logger.getLogger(TestServletContextListener.class.getName());
	
    
    
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		LOG.log(Level.FINE,"Test Servlet context listener is being destroyed");
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		LOG.log(Level.FINE,"Test Servlet context listener is being started");	
                //This is how you load an existing player. 
                Player p = PlayerFactoryMgr.getPlayerFactory("U0001").create();
                
                // this is how you create a new player. 
                Player p1 = PlayerFactoryMgr.getPlayerFactory("terence.hunt", "Terry", 12, "20 collingwood drive", "m", "t.a.hunt89@gmail.com").create();
	}
}