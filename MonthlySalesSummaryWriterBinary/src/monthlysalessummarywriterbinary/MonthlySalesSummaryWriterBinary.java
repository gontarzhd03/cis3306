/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monthlysalessummarywriterbinary;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author 55gontarhd03
 */
public class MonthlySalesSummaryWriterBinary {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String outFile = "./data/MonthlySalesSummary.dat";
        String outFileStreamName = "MonthlySalesSummary";
        
        try (DataOutputStream outDataStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(outFile)));) {
            for(int i = 1; i < 13; i++) {
                outDataStream.writeInt(i);
                outDataStream.writeInt(0);
            }
            System.out.println("File Complete.");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
