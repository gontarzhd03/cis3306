/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registrationdatabaseoperationsdriver;
import registrationdatabaseoperations.*;
/**
 *
 * @author 55gontarhd03
 */
public class RegistrationDatabaseOperationsDriver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int studentID = 2;
        String studentFirstName = "EDGAR";
        String studentLastName = "ROBINSON";
        
        RegistrationDatabaseOperations.setConnection("./data/RegistrationDerbyDatabase/", "Registration");
        insertField(studentID, studentFirstName, studentLastName);
        retrieveField(studentID);
        
        studentID = 5;
        studentFirstName = "PETER";
        studentLastName = "LORRE";
        insertField(studentID, studentFirstName, studentLastName);
        retrieveFields();
        
        insertCourse(2, "CIS 3306");
        insertCourse(2, "CIS 3308");
        insertCourse(5, "CIS 3306");
        insertCourse(5, "CIS 3340");        
        StudentScheduleEntries studentScheduleEntries = RegistrationDatabaseOperations.retrieveStudentSchedules();
        studentScheduleEntries.sort();;
        for(int i = 0; i < studentScheduleEntries.size(); i++) {
            System.out.println(studentScheduleEntries.get(i).getStudentId());
            System.out.println(studentScheduleEntries.get(i).getStudentFirstName());
            System.out.println(studentScheduleEntries.get(i).getStudentLastName());
            System.out.println(studentScheduleEntries.get(i).getCourseName());
        }
        System.out.println();
        studentScheduleEntries = RegistrationDatabaseOperations.retrieveStudentSchedule(5);
        for(int i = 0; i < studentScheduleEntries.size(); i++) {
            System.out.println(studentScheduleEntries.get(i).getStudentId());
            System.out.println(studentScheduleEntries.get(i).getStudentFirstName());
            System.out.println(studentScheduleEntries.get(i).getStudentLastName());
            System.out.println(studentScheduleEntries.get(i).getCourseName());
        }
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
