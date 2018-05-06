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
public class Students {
    ArrayList <Student> students = new ArrayList <Student> ();
    
    public void add(Student student) {
        students.add(student);
    }
    
    public Student get(int i) {
        return students.get(i);
    }

    public int size() {
        return students.size();
    }
}
