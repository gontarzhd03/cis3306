/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monthlysalesraf;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/**
 *
 * @author 55gontarhd03
 */
public class MonthlySalesRAF {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String inFile = "./data/MonthlySales.dat";
        String outFile = "./data/MonthlySalesSummary.dat";
        int monthNumber;
        int sales;
        int filePointer;
        
        try (DataInputStream inDataStream = new DataInputStream(new BufferedInputStream(new FileInputStream(inFile)));
            RandomAccessFile monthlySalesSummary = new RandomAccessFile(outFile, "rw");) {
            while (inDataStream.available() > 0) {
                monthNumber = inDataStream.readInt();
                filePointer = (monthNumber - 1) * 8 + 4;
                monthlySalesSummary.seek(filePointer);
                sales = monthlySalesSummary.readInt() + inDataStream.readInt();
                monthlySalesSummary.seek(filePointer);
                monthlySalesSummary.writeInt(sales);
            }
            System.out.println("File Complete.");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
