package employeesalesrelativedelete;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;

/**
 *
 * @author 55gontarhd03
 */
public class RelativeSalesRelativeDelete {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String inFile = "./data/EmployeeSalesRelative.dat";
        int recordLength = 8;
        int primeNumber = 213;
        int employeeNumber = 139654060;
        int newSales = 712329;
        ByteBuffer aByteBuffer;
        
        try (RelativeFile outDataStream = new RelativeFile(inFile, primeNumber, recordLength);) {
            Employee employee = new Employee(employeeNumber, newSales);
            aByteBuffer = outDataStream.retrieve(employeeNumber);
            System.out.println(aByteBuffer.getInt());
            System.out.println(aByteBuffer.getInt());
            outDataStream.deleteRecord(employeeNumber);
            aByteBuffer = outDataStream.retrieve(employeeNumber);

            System.out.println("File Complete");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
