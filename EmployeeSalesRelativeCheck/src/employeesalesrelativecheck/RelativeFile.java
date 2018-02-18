/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeesalesrelativecheck;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

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
    public int calculateRelativeKey(int i) {
        return (i % primeNumber) + 1;
    }
    public String checkRecordValid(int employeeNumber, int relativeKey) throws IOException {
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
}
