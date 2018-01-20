/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payrollwriterbinary;
import dao.LineSequential;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author 55gontarhd03
 */
public class PayrollWriterBinary {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String inFile = "./data/PayrollMaster.dat";
        String inFileStreamName = "payrollMasterA";
        String outFile = "./data/PayrollMasterBinary.dat";
        String inputLine;
        
        try(FileOutputStream outFileStream = new FileOutputStream(outFile);) {
            LineSequential.open(inFile, inFileStreamName, "input");
            while((inputLine = LineSequential.read(inFileStreamName)) != null) {
                outFileStream.write(inputLine.getBytes());
            }
            LineSequential.close(inFileStreamName, "input");
            System.out.println("File Complete");
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
