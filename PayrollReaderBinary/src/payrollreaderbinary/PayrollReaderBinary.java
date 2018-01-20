/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payrollreaderbinary;
import dao.LineSequential;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author 55gontarhd03
 */
public class PayrollReaderBinary {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String inFile = "./data/PayrollMasterBinary.dat";
        String outFileStreamName = "payrollMasterA";
        String outFile = "./data/PayrollMaster.dat";
        byte [] byteArray = new byte[80];
        String outputLine;
        
        try(FileInputStream inFileStream = new FileInputStream(inFile);) {
            LineSequential.open(outFile, outFileStreamName, "output");
            
            while(inFileStream.available() > 0) {
                inFileStream.read(byteArray);
                outputLine = new String(byteArray);
                LineSequential.write(outFileStreamName, outputLine);
            }
            LineSequential.close(outFileStreamName, "output");
            System.out.println("File Complete");
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
