/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monthlysales;
import dao.LineSequential;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.io.RandomAccessFile;
/**
 *
 * @author 55gontarhd03
 */
public class MonthlySalesRAFReport {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String inFile = "./data/MonthlySalesSummary.dat";
        String outFile = "./data/MonthlySalesSummary.txt";
        String outFileStreamName = "MonthlySalesSummary";
        SimpleDateFormat dateFormatStandard = new SimpleDateFormat("M/d/YYYY");
        Date today = new Date();
        String headingString1 = BlankRecord.moveSpaces(8) + "Monthly Sales Report" + BlankRecord.moveSpaces(10) + dateFormatStandard.format(today);
        String headingString2 = BlankRecord.moveSpaces(5) + "Month" + BlankRecord.moveSpaces(14) + "Sales";
        DecimalFormat monthFormat = new DecimalFormat("00");
        DecimalFormat salesFormat = new DecimalFormat("$###,##0");
        int monthNumber;
        int sales;

        try (RandomAccessFile inDataStream = new RandomAccessFile(inFile, "r");) {
            initialization(outFile, outFileStreamName, headingString1, headingString2);
            
            while (inDataStream.getFilePointer() < inDataStream.length()) {
                monthNumber = inDataStream.readInt();
                sales = inDataStream.readInt();
                outputRecord(monthNumber, sales, monthFormat, salesFormat, outFileStreamName);
            }
            
            termination(outFileStreamName);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    static void initialization(String outFile, String outFileStreamName, String headingString1, String headingString2){
        LineSequential.open(outFile, outFileStreamName, "output");
        LineSequential.write(outFileStreamName, headingString1);
        LineSequential.write(outFileStreamName, "");
        LineSequential.write(outFileStreamName, headingString2);
    }
    static void outputRecord(int monthNumber, int sales, DecimalFormat monthFormat, DecimalFormat salesFormat, String outFileStreamName) {
        String outputLine;

        outputLine = BlankRecord.moveSpaces(6) + monthFormat.format(monthNumber) + BlankRecord.moveSpaces(14) + salesFormat.format(sales);
        LineSequential.write(outFileStreamName, outputLine);
    }
    static void termination(String outFileStreamName){
        LineSequential.close(outFileStreamName, "output");
        System.out.println("File Complete.");
    }
}
