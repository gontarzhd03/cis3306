/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payrollwriterbinary2;
import dao.LineSequential;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
/**
 *
 * @author 55gontarhd03
 */
public class PayrollWriterBinary2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String inFile1 = "./data/PayrollMaster.dat";
        String inFileStreamName1 = "payrollMasterA";
        String outFile = "./data/PayrollMasterBinary.dat";
        int[] employeeMarksOut = {0, 5, 25, 27, 29, 35};
        String inputLine;

        try (FileOutputStream outFileStream = new FileOutputStream(outFile);) {
            LineSequential.open(inFile1, inFileStreamName1, "input");

            while ((inputLine = LineSequential.read(inFileStreamName1)) != null) {
                write(outFileStream, inputLine, employeeMarksOut);
            }
            LineSequential.close(inFileStreamName1, "input");
            System.out.println("File Complete");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    static void write(FileOutputStream outFileStream, String inputLine, int[] employeeMarksOut) throws IOException {
        ByteBuffer byteBufferInt = ByteBuffer.allocate(4);
        byteBufferInt.putInt(Integer.valueOf(inputLine.substring(employeeMarksOut[0], employeeMarksOut[1])));
        outFileStream.write(byteBufferInt.array());
        outFileStream.write(inputLine.substring(employeeMarksOut[1], employeeMarksOut[2]).getBytes());
        byteBufferInt.clear();
        
        byteBufferInt.putInt(Integer.valueOf(inputLine.substring(employeeMarksOut[2], employeeMarksOut[3])));
        outFileStream.write(byteBufferInt.array());
        byteBufferInt.clear();
        
        byteBufferInt.putInt(Integer.valueOf(inputLine.substring(employeeMarksOut[4], employeeMarksOut[5])));
        outFileStream.write(byteBufferInt.array());
    }
}
