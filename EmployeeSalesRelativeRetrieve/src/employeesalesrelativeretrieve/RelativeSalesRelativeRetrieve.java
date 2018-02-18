/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeesalesrelativeretrieve;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;

/**
 *
 * @author 55gontarhd03
 */
public class RelativeSalesRelativeRetrieve {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String inFile = "./data/EmployeeSalesRelative.dat";
        int recordLength = 8;
        int primeNumber = 213;
        int employeeNumber = 139654059;
        
        try (RelativeFile outDataStream = new RelativeFile(inFile, primeNumber, recordLength);) {
            ByteBuffer aByteBuffer = outDataStream.retrieve(employeeNumber);
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
