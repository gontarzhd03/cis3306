/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monthlysales1writerbinary;

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
public class MonthlySales1WriterBinary {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String inFile1 = "./data/Month.dat";
        String inFileStreamName1 = "Month";
        String inFile2 = "./data/Sales.dat";
        String inFileStreamName2 = "Sales";
        String outFile = "./data/MonthlySales.dat";
        String inputLine;
        
        try (DataOutputStream outDataStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(outFile)));) {
            LineSequential.open(inFile1, inFileStreamName1, "input");
            LineSequential.open(inFile2, inFileStreamName2, "input");
            
            while ((inputLine = LineSequential.read(inFileStreamName1)) != null) {
                outDataStream.writeInt(Integer.valueOf(inputLine.trim()));
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
}
