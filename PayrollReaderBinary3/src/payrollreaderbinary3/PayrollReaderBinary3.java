/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payrollreaderbinary3;

import dao.LineSequential;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author hgontarz
 */
public class PayrollReaderBinary3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String inFile = "./data/PayrollMasterBinary.dat";
        String outFile = "./data/PayrollMaster.dat";
        String outFileStreamName = "payrollMasterA";

        try (DataInputStream inDataStream = new DataInputStream(new BufferedInputStream(new FileInputStream(inFile)));) {
            LineSequential.open(outFile, outFileStreamName, "output");
            while (inDataStream.available() > 0) {
                String employeeRecord = "";
                employeeRecord = String.valueOf(inDataStream.readInt());
                for (int i = 0; i < 20; i++) {
                    employeeRecord = employeeRecord + String.valueOf(inDataStream.readChar());
                }
                employeeRecord = employeeRecord + String.valueOf(inDataStream.readInt());
                employeeRecord = employeeRecord + String.valueOf(inDataStream.readInt());
                LineSequential.write(outFileStreamName, employeeRecord);
            }
            LineSequential.close(outFileStreamName, "output");
            System.out.println("File Complete");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
