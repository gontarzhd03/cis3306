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
public class StudentScheduleEntries {
    private ArrayList <StudentScheduleEntry> studentScheduleEntries = new ArrayList <StudentScheduleEntry> ();
    
    public void add(StudentScheduleEntry studentScheduleEntry) {
        studentScheduleEntries.add(studentScheduleEntry);
    }
    
    public StudentScheduleEntry get(int i) {
        return studentScheduleEntries.get(i);
    }

    public int size() {
        return studentScheduleEntries.size();
    }
    
    public void sort() {
        studentScheduleEntries.sort(null);
    }
}
