/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registrationmysqldatabasefill;

import registrationdatabaseoperations.Course;
import registrationdatabaseoperations.RegistrationDatabaseOperations;
import registrationdatabaseoperations.Student;
import registrationdatabaseoperations.Students;

/**
 *
 * @author 55gontarhd03
 */
public class RegistrationMySQLDatabaseFill {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String dbProtocol = "jdbc:mysql://13.58.105.195:3306/";
        String dbDirectory = "";
        String dbName = "Registration";
        String dbExtra = "";
        String userName = "root";
        String passWord = "Howdy1234";
        
        RegistrationDatabaseOperations.setConnection(dbProtocol, dbDirectory, dbName, dbExtra, userName, passWord);
        int studentId = 2;
        String studentFirstName = "EDGAR";
        String studentLastName = "ROBINSON";
        insertField(studentId, studentFirstName, studentLastName);
        retrieveField(studentId);

        studentId = 5;
        studentFirstName = "PETER";
        studentLastName = "LORRE";
        insertField(studentId, studentFirstName, studentLastName);
        retrieveFields();
        
        insertCourse(2, "CIS 3306");
        insertCourse(2, "CIS 3308");
        insertCourse(5, "CIS 3306");
        insertCourse(5, "CIS 3340");
    }
    
    static void retrieveFields() {
        Students students = RegistrationDatabaseOperations.retrieveAllStudents();
        for(int i = 0; i < students.size(); i++) {
            System.out.println(students.get(i).getStudentID());
            System.out.println(students.get(i).getStudentFirstName());
            System.out.println(students.get(i).getStudentLastName());
            System.out.println();
        }
    }

    static void retrieveField(int studentID) {
        Student student = RegistrationDatabaseOperations.retrieveStudent(studentID);
        System.out.println(student.getStudentID());
        System.out.println(student.getStudentFirstName());
        System.out.println(student.getStudentLastName());
        System.out.println();
    }

    static void insertField(int studentID, String studentFirstName, String studentLastName) {
        Student newStudent = new Student();
        newStudent.setStudentID(studentID);
        newStudent.setStudentFirstName(studentFirstName);
        newStudent.setStudentLastName(studentLastName);
        RegistrationDatabaseOperations.insertStudent(newStudent);
    }
    static void insertCourse(int studentID, String courseName) {
        Course newCourse = new Course();
        newCourse.setStudentID(studentID);
        newCourse.setCourseName(courseName);
        RegistrationDatabaseOperations.insertCourse(newCourse);
    }
}
