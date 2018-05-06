/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registrationdatabaseoperations;
import java.util.*;

/**
 *
 * @author hgontarz
 */
public class StudentScheduleEntry implements Comparable {
    private int studentId;
    private String studentFirstName;
    private String studentLastName;
    private String courseName;

    public StudentScheduleEntry() {
    }

    public StudentScheduleEntry(Student studentIn, Course courseIn) {
        this.studentId = studentIn.getStudentID();
        this.studentFirstName = studentIn.getStudentFirstName();
        this.studentLastName = studentIn.getStudentLastName();
        this.courseName = courseIn.getCourseName();
    }
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
    
    public String getStudentFirstName() {
        return studentFirstName;
    }

    public void setStudentFirstName(String studentFirstName) {
        this.studentFirstName = studentFirstName;
    }

    public String getStudentLastName() {
        return studentLastName;
    }

    public void setStudentLastName(String studentLastName) {
        this.studentLastName = studentLastName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    
    @Override
    public int compareTo(Object studentScheduleEntry) {
        if(studentId == ((StudentScheduleEntry) studentScheduleEntry).getStudentId()) {
            return 0;
        }
        else if(studentId > ((StudentScheduleEntry) studentScheduleEntry).getStudentId()) {
            return 1;
        }
        else {
            return -1;
        }
    }
    
}
