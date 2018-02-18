/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeessalesrelativewriterbinary;

import dao.LineSequential;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/**
 *
 * @author 55gontarhd03
 */
public class EmployeesSalesRelativeWriterBinary {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String inFile1 = "./data/Employee.txt";
        String inFileStreamName1 = "Month";
        String inFile2 = "./data/Sales.txt";
        String inFileStreamName2 = "Sales";
        String outFile = "./data/EmployeeSalesRelative.dat";
        String inputLine;
        int filePointer;
        int recordNumber;
        int employeeNumber;
        
        try (RandomAccessFile outDataStream = new RandomAccessFile(outFile, "rw");) {
            LineSequential.open(inFile1, inFileStreamName1, "input");
            LineSequential.open(inFile2, inFileStreamName2, "input");
            
            while ((inputLine = LineSequential.read(inFileStreamName1)) != null) {
                employeeNumber = Integer.valueOf(inputLine.trim());
                recordNumber = hashFunction(employeeNumber);
                filePointer = (recordNumber - 1) * 8;
                outDataStream.seek(filePointer);
                outDataStream.writeInt(employeeNumber);
                inputLine = LineSequential.read(inFileStreamName2);
                outDataStream.writeInt(Integer.valueOf(inputLine.trim()));
            }
            LineSequential.close(inFileStreamName1, "input");
            LineSequential.close(inFileStreamName2, "input");
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
