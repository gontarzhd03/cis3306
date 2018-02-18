/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeesalesrelativecheck;
import dao.LineSequential;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author 55gontarhd03
 */
public class EmployeeSalesRelativeCheck {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String inFile1 = "./data/Employee.txt";
        String inFileStreamName1 = "Month";
        String inFile = "./data/EmployeeSalesRelative.dat";
        String inputLine;
        int recordLength = 8;
        int primeNumber = 213;
        int employeeNumber;
        String validRecord;
        
        try (RelativeFile outDataStream = new RelativeFile(inFile, primeNumber, recordLength);) {
            LineSequential.open(inFile1, inFileStreamName1, "input");
            while ((inputLine = LineSequential.read(inFileStreamName1)) != null) {
                employeeNumber = Integer.valueOf(inputLine.trim());
                int relativeKey = outDataStream.calculateRelativeKey(employeeNumber);
                validRecord = outDataStream.checkRecordValid(employeeNumber, relativeKey);
                System.out.println(validRecord);
            }
            LineSequential.close(inFileStreamName1, "input");
            System.out.println("File Complete");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
}
