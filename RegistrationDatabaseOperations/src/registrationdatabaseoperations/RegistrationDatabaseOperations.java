/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registrationdatabaseoperations;

import registrationdatabaseoperations.Course;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author hgontarz
 */
public class RegistrationDatabaseOperations {
   private static String dbProtocol = "jdbc:derby:";
   private static String dbDirectory = "./data/RegistrationDerbyDatabase/";
   private static String dbName = "Registration";
   private static String dbExtra = "";
   private static String userName = "Admin";
   private static String passWord = "MuCis";
   
   public static void setConnection(String dbDirectoryIn, String dbNameIn) {
      dbDirectory = dbDirectoryIn;
      dbName = dbNameIn;
   }
   
   public static void setConnection(String dbDirectoryIn, String dbNameIn, String userNameIn, String passWordIn) {
      dbDirectory = dbDirectoryIn;
      dbName = dbNameIn;
      userName = userNameIn;
      passWord = passWordIn;
   }
   
   public static void setConnection(String dbProtocolIn, String dbDirectoryIn, String dbNameIn, String dbExtraIn, String userNameIn, String passWordIn) {
      dbProtocol = dbProtocolIn;
      dbDirectory = dbDirectoryIn;
      dbName = dbNameIn;
      dbExtra = dbExtraIn;
      userName = userNameIn;
      passWord = passWordIn;
   }
   
    private static Connection openConnection() throws SQLException {        
        String connectionURL = dbProtocol + dbDirectory + dbName + dbExtra;
        Connection connection1 = DriverManager.getConnection(connectionURL, userName, passWord);
        return connection1;
    }
    
    public static Students retrieveAllStudents() {
        String query1 = "SELECT * FROM Student";
        Students students = new Students();
        try(Connection connection1 = openConnection()) {
            Statement statement = connection1.createStatement();
            ResultSet rs1 = statement.executeQuery(query1);
            while(rs1.next()) {
                Student studentNext = new Student();
                studentNext.setStudentID(rs1.getInt(1));
                studentNext.setStudentFirstName(rs1.getString(2));
                studentNext.setStudentLastName(rs1.getString(3));
                students.add(studentNext);
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return students;
    }
    
    public static Student retrieveStudent(int studentID) {
        String query1 = "SELECT * FROM Student WHERE StudentID = ? ";
        Student studentNext = new Student();
        try(Connection connection1 = openConnection()) {
            PreparedStatement statement = connection1.prepareStatement(query1);
            statement.setInt(1, studentID);
            ResultSet rs1 = statement.executeQuery();
            if(rs1.next()) {
                studentNext.setStudentID(rs1.getInt(1));
                studentNext.setStudentFirstName(rs1.getString(2));
                studentNext.setStudentLastName(rs1.getString(3));
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return studentNext;
    }
    
    public static void insertStudent(Student student) {
        String insertStatementStudent = "INSERT INTO Student (StudentID, StudentFirstName, StudentLastName) VALUES(?, ?, ?) ";
        
        try(Connection connection1 = openConnection()) {
            PreparedStatement statement = connection1.prepareStatement(insertStatementStudent);
            statement.setInt(1, student.getStudentID());
            statement.setString(2, student.getStudentFirstName());
            statement.setString(3, student.getStudentLastName());
            statement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }        
    }
    
    public static void modifyStudentFirstName(String modifyFieldValue, int conditionFieldValue) {
        String modifyStatement = "UPDATE Student SET StudentFirstName ? WHERE StudentID = ? ";
        
        try(Connection connection1 = openConnection()) {
            PreparedStatement statement = connection1.prepareStatement(modifyStatement);
            statement.setString(1, modifyFieldValue);
            statement.setInt(2, conditionFieldValue);
            statement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    public static void modifyStudentLastName(String modifyFieldValue, int conditionFieldValue) {
        String modifyStatement = "UPDATE Student SET StudentLastName ? WHERE StudentID = ? ";
        
        try(Connection connection1 = openConnection()) {
            PreparedStatement statement = connection1.prepareStatement(modifyStatement);
            statement.setString(1, modifyFieldValue);
            statement.setInt(2, conditionFieldValue);
            statement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    public static void deleteStudent(int conditionFieldValue) {
        String deleteStatement = "DELETE FROM Student WHERE StudentID = ? ";
        
        try(Connection connection1 = openConnection()) {
            PreparedStatement statement = connection1.prepareStatement(deleteStatement);
            statement.setInt(1, conditionFieldValue);
            statement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    public static ArrayList getStudentFieldNames() {
        String query1 = "SELECT * FROM Student";
        ArrayList <String> columnNames = new ArrayList<String>();
        Students students = new Students();
        try(Connection connection1 = openConnection()) {
            Statement statement = connection1.createStatement();
            ResultSet rs1 = statement.executeQuery(query1);
            ResultSetMetaData rsm1 = rs1.getMetaData();
            for(int columnNumber = 1; columnNumber <= rsm1.getColumnCount(); columnNumber++) {
                columnNames.add(rsm1.getColumnName(columnNumber));
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return columnNames;
    }
    
    public static void insertCourse(Course course) {
        String insertStatementCourse = "INSERT INTO Course (StudentID, CourseName) VALUES(?, ?) ";
        
        try(Connection connection1 = openConnection()) {
            PreparedStatement statement = connection1.prepareStatement(insertStatementCourse);
            statement.setInt(1, course.getStudentID());
            statement.setString(2, course.getCourseName());
            statement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }        
    }

    public static StudentScheduleEntries retrieveStudentSchedule(int studentID) {
        String query1 = "SELECT * FROM Student INNER JOIN Course ON Student.StudentID = Course.StudentID WHERE Student.StudentID = ? ";
        StudentScheduleEntries studentScheduleEntries = new StudentScheduleEntries();
        try(Connection connection1 = openConnection()) {
            PreparedStatement statement = connection1.prepareStatement(query1);
            statement.setInt(1, studentID);
            ResultSet rs1 = statement.executeQuery();
            while(rs1.next()) {
                StudentScheduleEntry studentScheduleEntryNext = new StudentScheduleEntry();
                studentScheduleEntryNext.setStudentId(rs1.getInt(1));
                studentScheduleEntryNext.setStudentFirstName(rs1.getString(2));
                studentScheduleEntryNext.setStudentLastName(rs1.getString(3));
                studentScheduleEntryNext.setCourseName(rs1.getString(5));
                studentScheduleEntries.add(studentScheduleEntryNext);
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return studentScheduleEntries;
    }
    
    public static StudentScheduleEntries retrieveStudentSchedules() {
        String query1 = "SELECT * FROM Student INNER JOIN Course ON Student.StudentID = Course.StudentID ";
        StudentScheduleEntries studentScheduleEntries = new StudentScheduleEntries();
        try(Connection connection1 = openConnection()) {
            Statement statement = connection1.createStatement();
            ResultSet rs1 = statement.executeQuery(query1);
            while(rs1.next()) {
                StudentScheduleEntry studentScheduleEntryNext = new StudentScheduleEntry();
                studentScheduleEntryNext.setStudentId(rs1.getInt(1));
                studentScheduleEntryNext.setStudentFirstName(rs1.getString(2));
                studentScheduleEntryNext.setStudentLastName(rs1.getString(3));
                studentScheduleEntryNext.setCourseName(rs1.getString(5));
                studentScheduleEntries.add(studentScheduleEntryNext);
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return studentScheduleEntries;
    }


}
