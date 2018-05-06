/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registrationdatabaseoperations;
import javafx.beans.property.*;

/**
 *
 * @author hgontarz
 */
public class Student {
    private SimpleIntegerProperty studentIDProperty = new SimpleIntegerProperty();
    private SimpleStringProperty studentFirstNameProperty = new SimpleStringProperty();
    private SimpleStringProperty studentLastNameProperty = new SimpleStringProperty();
    
    private int studentID;
    private String studentFirstName;
    private String studentLastName;

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
        this.studentIDProperty.set(studentID);
    }

    public String getStudentFirstName() {
        return studentFirstName;
    }

    public void setStudentFirstName(String studentFirstName) {
        this.studentFirstName = studentFirstName;
        this.studentFirstNameProperty.set(studentFirstName);
    }

    public String getStudentLastName() {
        return studentLastName;
    }

    public void setStudentLastName(String studentLastName) {
        this.studentLastName = studentLastName;
        this.studentLastNameProperty.set(studentLastName);
    }
    
    public int getStudentIDProperty() {
        return studentIDProperty.get();
    }

    public void setStudentIDProperty(int studentID) {
        this.studentIDProperty.set(studentID);
        this.studentID = studentID;        
    }

    public String getStudentFirstNameProperty() {
        return studentFirstNameProperty.get();
    }

    public void setStudentFirstNameProperty(String studentFirstName) {
        this.studentFirstNameProperty.set(studentFirstName);
        this.studentFirstName = studentFirstName;
    }
    
    public String getStudentLastNameProperty() {
        return studentLastNameProperty.get();
    }

    public void setStudentLastNameProperty(String studentLastName) {
        this.studentLastNameProperty.set(studentLastName);
        this.studentLastName = studentLastName;
    }
}
