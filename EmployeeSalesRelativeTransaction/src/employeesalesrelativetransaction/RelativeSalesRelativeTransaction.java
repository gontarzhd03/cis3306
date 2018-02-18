package employeesalesrelativetransaction;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;

/**
 *
 * @author 55gontarhd03
 */
public class RelativeSalesRelativeTransaction {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String inFile = "./data/EmployeeSalesRelative.dat";
        int recordLength = 8;
        int primeNumber = 213;
        int employeeNumber = 139654060;
        ByteBuffer aByteBuffer;
        int offset = 4;
        
        try (RelativeFile outDataStream = new RelativeFile(inFile, primeNumber, recordLength);) {
            aByteBuffer = outDataStream.retrieve(employeeNumber);
            System.out.println(aByteBuffer.getInt());
            System.out.println(aByteBuffer.getInt());
            outDataStream.deleteRecord(employeeNumber);
            int relativeKey = (employeeNumber % primeNumber) + 1;
            outDataStream.seek((relativeKey - 1) * recordLength + offset);
            System.out.println("Deleted Record Sales = " + outDataStream.readInt());

            System.out.println("File Complete");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
