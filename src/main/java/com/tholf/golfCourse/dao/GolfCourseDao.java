/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tholf.golfCourse.dao;

import com.tholf.golfCourse.GolfCourse;
import com.tholf.player.*;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author thunt
 * @param <T>
 */
public interface GolfCourseDao<T extends GolfCourse> 
 {
    void updateGolfCourse(T p) throws SQLException;
    void deleteGolfCourse(T p) throws SQLException;
    Player getGolfCourse(String uid) throws SQLException;
    List<T> getAllGolfCourses() throws SQLException;

}
