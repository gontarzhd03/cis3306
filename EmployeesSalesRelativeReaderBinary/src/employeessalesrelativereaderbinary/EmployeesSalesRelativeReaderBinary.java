/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeessalesrelativereaderbinary;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author 55gontarhd03
 */
public class EmployeesSalesRelativeReaderBinary {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String inFile = "./data/EmployeeSalesRelative.dat";
        int recordNumber = 1;
        int sales;
        int employeeNumber;
        
        try (RandomAccessFile outDataStream = new RandomAccessFile(inFile, "r");) {
            while (outDataStream.getFilePointer() < outDataStream.length()) {
                employeeNumber = outDataStream.readInt();
                if(employeeNumber > 0) {
                    System.out.println("Record Number = " + recordNumber + "     index - " + hashFunction(employeeNumber));
                    sales = outDataStream.readInt();
                    System.out.println("Employee Number = " + employeeNumber + "     Sales - " + sales);
                    recordNumber++;
                }
            }
            System.out.println("File Complete");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    static int hashFunction(int i) {
        return (i % 213) + 1;
    }
}
