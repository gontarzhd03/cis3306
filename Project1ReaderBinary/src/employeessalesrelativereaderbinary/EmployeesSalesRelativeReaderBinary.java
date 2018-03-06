/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeessalesrelativereaderbinary;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author 55gontarhd03
 */
public class EmployeesSalesRelativeReaderBinary {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String inFile = "./data/ProjectI.dat";
        int recordNumber = 1;
        int sales;
        float commission;
        int employeeNumber;
        int offsetRemaining = 28;
        byte [] aByteArray = new byte[20];
        
        try (RandomAccessFile outDataStream = new RandomAccessFile(inFile, "r");) {
            while (outDataStream.getFilePointer() < outDataStream.length()) {
                employeeNumber = outDataStream.readInt();
                if(employeeNumber > 0) {
                    System.out.print("Record Number = " + recordNumber + " index - " + hashFunction(employeeNumber));
                    sales = outDataStream.readInt();
                    outDataStream.readFully(aByteArray);
                    String region = new String(aByteArray, "UTF-8");
                    commission = outDataStream.readFloat();
                    System.out.println(" Employee# = " + employeeNumber + " Sales = " + sales + " Region = " + region + " Commission = " + commission);
                    recordNumber++;
                }
                else {
                    outDataStream.seek(outDataStream.getFilePointer() + offsetRemaining);
                }
            }
            System.out.println("File Complete");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    static int hashFunction(int i) {
        return (i % 271) + 1;
    }
}
