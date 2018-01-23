/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payrollreaderbinary2;
import dao.LineSequential;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;

/**
 *
 * @author 55gontarhd03
 */
public class PayrollReaderBinary2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String inFile = "./data/PayrollMasterBinary.dat";
        String outFileStreamName = "payrollMasterA";
        String outFile = "./data/PayrollMaster.dat";
        int[] employeeMarksOut = {0, 5, 25, 27, 29, 35};
        String inputLine;
		
        try (FileInputStream inFileStream = new FileInputStream(inFile);) {
            LineSequential.open(outFile, outFileStreamName, "output");
            while (inFileStream.available() > 0) {
                write(inFileStream, outFileStreamName);
            }
            LineSequential.close(outFileStreamName, "output");
            System.out.println("File Complete");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    static void write(FileInputStream inFileStream, String outFileStreamName) throws IOException {
        String outputLine;
        ByteBuffer byteBufferInt = ByteBuffer.allocate(4);
        byte [] byteArray = new byte[4];
        inFileStream.read(byteArray);
        byteBufferInt.put(byteArray);
        byteBufferInt.position(0);
        outputLine = Integer.toString(byteBufferInt.getInt());
        
        byte [] byteArrayString = new byte[20];
        inFileStream.read(byteArrayString);
        String employeeName = new String(byteArrayString);
        outputLine = outputLine + employeeName;
        
        inFileStream.read(byteArray);
        byteBufferInt.clear();
        byteBufferInt.put(byteArray);
        byteBufferInt.position(0);
        outputLine = outputLine + Integer.toString(byteBufferInt.getInt());
        
        inFileStream.read(byteArray);
        byteBufferInt.clear();
        byteBufferInt.put(byteArray);
        byteBufferInt.position(0);
        outputLine = outputLine + Integer.toString(byteBufferInt.getInt());
        LineSequential.write(outFileStreamName, outputLine);
    }
}
