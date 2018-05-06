/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkregistrationconnectionmysql;
import java.sql.*;

/**
 *
 * @author 55gontarhd03
 */
public class CheckRegistrationConnectionMySQL {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Connection connection1 = DriverManager.getConnection("jdbc:mysql://18.219.105.110:3306/Registration?useSSL=false", "root", "Howdy1234");
            System.out.println("Connection - " + connection1.toString());
            connection1.close();
        }
        catch(SQLException e) {
            System.out.println(e.toString());
        }
    }
    
}
