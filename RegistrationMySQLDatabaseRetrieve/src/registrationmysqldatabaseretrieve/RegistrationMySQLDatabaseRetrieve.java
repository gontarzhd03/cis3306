/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registrationmysqldatabaseretrieve;
import registrationdatabaseoperations.*;

/**
 *
 * @author 55gontarhd03
 */
public class RegistrationMySQLDatabaseRetrieve {

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
    
}
