/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registrationdatabaseoperations;

import java.util.ArrayList;

/**
 *
 * @author hgontarz
 */
public class Courses {
    private ArrayList <Course> courses = new ArrayList <Course> ();
    
    public void add(Course course) {
        courses.add(course);
    }
    
    public Course get(int i) {
        return courses.get(i);
    }

    public int size() {
        return courses.size();
    }
}
