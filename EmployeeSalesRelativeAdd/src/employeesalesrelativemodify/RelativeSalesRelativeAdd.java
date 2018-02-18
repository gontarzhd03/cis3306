/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeesalesrelativemodify;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;

/**
 *
 * @author 55gontarhd03
 */
public class RelativeSalesRelativeAdd {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String inFile = "./data/EmployeeSalesRelative.dat";
        int recordLength = 8;
        int primeNumber = 213;
        int employeeNumber = 139654060;
        int newSales = 712329;
        ByteBuffer aByteBuffer;
        
        try (RelativeFile outDataStream = new RelativeFile(inFile, primeNumber, recordLength);) {
            Employee employee = new Employee(employeeNumber, newSales);
//            outDataStream.addRecord(employee);
            outDataStream.addRecord(employee.toBytes(), employee.getEmployeeNumber());
            aByteBuffer = outDataStream.retrieve(employee.getEmployeeNumber());
            System.out.println(aByteBuffer.getInt());
            System.out.println(aByteBuffer.getInt());

            System.out.println("File Complete");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
}
