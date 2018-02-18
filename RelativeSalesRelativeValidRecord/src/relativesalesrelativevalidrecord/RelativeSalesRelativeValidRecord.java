/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relativesalesrelativevalidrecord;
import dao.LineSequential;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author 55gontarhd03
 */
public class RelativeSalesRelativeValidRecord {

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
        
        try (RandomAccessFile outDataStream = new RandomAccessFile(inFile, "r");) {
            LineSequential.open(inFile1, inFileStreamName1, "input");
            while ((inputLine = LineSequential.read(inFileStreamName1)) != null) {
                employeeNumber = Integer.valueOf(inputLine.trim());
                validRecord = checkRecordValid(outDataStream, employeeNumber, recordLength, primeNumber);
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
    static int calculateRelativeKey(int i, int primeNumber) {
        return (i % primeNumber) + 1;
    }
    static String checkRecordValid(RandomAccessFile outDataStream, int employeeNumber, int recordLength, int primeNumber) {
        try {
            int relativeKey = calculateRelativeKey(employeeNumber, primeNumber);
            outDataStream.seek((relativeKey - 1) * recordLength);
            int storedEmployeeNumber = outDataStream.readInt();
            if(storedEmployeeNumber == 0) {
                return "No";
            }
            else {
                if(storedEmployeeNumber == employeeNumber) {
                    return "Yes";
                }
                else {
                    System.out.println("Employee Number = " + employeeNumber + "     Relative Key = " + relativeKey);
                    return "Collision";
                }
            }
        } catch (IOException e) {
            System.out.println("IO Exception");
            return "IO Exception";
        }
    }
}
