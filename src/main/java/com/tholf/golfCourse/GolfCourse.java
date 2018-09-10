/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tholf.golfCourse;

import com.tholf.config.Conf;
import com.tholf.config.GolfCourseKeys;
import com.tholf.util.Address;
import com.tholf.util.UID;
import com.tholf.util.UidGenerator;
import java.util.Map;

/**
 *
 * @author thunt
 */
public class GolfCourse implements UID {

    String uid;
    String name;
    Address address;
    Map<Integer, Hole> holes;
    public static final String UID_PREFIX = Conf.COURSE.getString(GolfCourseKeys.UID_PREFIX);

    public GolfCourse(String name, Address address, Map<Integer, Hole> holes) {
        this(null,name,address,holes);
    }

    public GolfCourse(String uid, String name, Address address, Map<Integer, Hole> holes) {
        if(uid == null){
            uid = UidGenerator.generateUid(UID_PREFIX);
        }
        this.uid = uid;
        this.name = name;
        this.address = address;
        this.holes = holes;
    }

    @Override
    public String getUid() {
        return uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Map<Integer, Hole> getHoles() {
        return holes;
    }

    public void setHoles(Map<Integer, Hole> holes) {
        this.holes = holes;
    }
}
