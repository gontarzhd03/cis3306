/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeesalesrelativeretrieve;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;

/**
 *
 * @author 55gontarhd03
 */
public class RelativeFile extends RandomAccessFile {
    int primeNumber;
    int recordLength;

    RelativeFile(String ioFile, int primeNumberIn, int recordLengthIn) throws FileNotFoundException {
        super(ioFile, "rw");
        primeNumber = primeNumberIn;
        recordLength = recordLengthIn;
    }
    private int calculateRelativeKey(int i) {
        return (i % primeNumber) + 1;
    }
    private String checkRecordValid(int employeeNumber, int relativeKey) throws IOException {
        this.seek((relativeKey - 1) * recordLength);
        int storedEmployeeNumber = this.readInt();
        if(storedEmployeeNumber == 0) {
            return "No";
        }
        else {
            if(storedEmployeeNumber == employeeNumber) {
                return "Yes";
            }
            else {
                System.out.println("Employee Number = " + employeeNumber + "     Relative Key = " + relativeKey);
                return "Collision";
            }
        }
    }
    public ByteBuffer retrieve(int employeeNumber) throws IOException {
        ByteBuffer aByteBuffer = null;
        byte [] aByteArray = new byte[recordLength];
        int relativeKey = this.calculateRelativeKey(employeeNumber);
        String validRecord = this.checkRecordValid(employeeNumber, relativeKey);
        switch(validRecord) {
            case "Yes":
                this.seek((relativeKey - 1) * recordLength);
                this.readFully(aByteArray);
                aByteBuffer = ByteBuffer.wrap(aByteArray);
                break;
            case "No":
                System.out.println("Error Not A Valid Record");
                break;
            case "Collision":
                System.out.println("Error A Collision");
                break;
        }
        return aByteBuffer;
    }
}
