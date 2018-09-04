/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tholf.util;

import java.util.HashMap;

/**
 *
 * @author thunt
 */
public class UidGenerator {
    private static int counter=0;
    static HashMap<String,Integer> counters = new HashMap<String, Integer>();
    
    public static synchronized String generateUid(String prefix){
        if(!counters.containsKey(prefix)){
            counters.put(prefix, 100);
        }
        int x = counters.get(prefix);
        counters.put(prefix, x+1);
        return prefix + "_" + counters.get(prefix);
    }
    
}
