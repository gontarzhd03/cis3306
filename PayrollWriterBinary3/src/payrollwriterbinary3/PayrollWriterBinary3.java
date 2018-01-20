/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payrollwriterbinary3;

import dao.LineSequential;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author hgontarz
 */
public class PayrollWriterBinary3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String inFile = "./data/PayrollMaster.dat";
        String inFileStreamName = "payrollMasterA";
        String outFile = "./data/PayrollMasterBinary.dat";
        int[] employeeMarksOut = {0, 5, 25, 27, 29, 35};
        String inputLine;

        try (DataOutputStream outDataStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(outFile)));) {
            LineSequential.open(inFile, inFileStreamName, "input");

            while ((inputLine = LineSequential.read(inFileStreamName)) != null) {
                write(outDataStream, inputLine, employeeMarksOut);
            }
            LineSequential.close(inFileStreamName, "input");
            System.out.println("File Complete");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    static void write(DataOutputStream outDataStream, String inputLine, int[] employeeMarksOut) throws IOException {
        outDataStream.writeInt(Integer.valueOf(inputLine.substring(employeeMarksOut[0], employeeMarksOut[1])));
        outDataStream.writeChars((inputLine.substring(employeeMarksOut[1], employeeMarksOut[2])));
        outDataStream.writeInt(Integer.valueOf(inputLine.substring(employeeMarksOut[2], employeeMarksOut[3])));
        outDataStream.writeInt(Integer.valueOf(inputLine.substring(employeeMarksOut[4], employeeMarksOut[5])));
    }
}
