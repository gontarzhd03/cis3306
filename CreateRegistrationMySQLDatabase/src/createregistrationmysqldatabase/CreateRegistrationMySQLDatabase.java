/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package createregistrationmysqldatabase;
import java.sql.*;


/**
 *
 * @author 55gontarhd03
 */
public class CreateRegistrationMySQLDatabase {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String createStudentTable = "CREATE TABLE Student (StudentID INTEGER PRIMARY KEY, StudentFirstName VARCHAR(20), StudentLastName VARCHAR(20))";
        String createCourseTable = "CREATE TABLE Course (StudentID INTEGER, CourseName VARCHAR(20))";
        try {
            Connection connection1 = DriverManager.getConnection("jdbc:mysql://18.219.105.110:3306/Registration?useSSL=false", "root", "Howdy1234");
            System.out.println("Connection - " + connection1.toString());
            Statement statement1 = connection1.createStatement();
            statement1.execute(createStudentTable);
            statement1.execute(createCourseTable);
            connection1.close();
        }
        catch(SQLException e) {
            System.out.println(e.toString());
        }
    }
    
}
