package employeesalesrelativetransaction;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import dao.LineSequential;

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
        String transactionFile = "./data/SalesTransaction.dat";
        String transactionFileStreamName = "SalesTransaction";
        String inputLine;
        int [] employeeRecordInMarks = {9, 15, 16};
        int recordLength = 8;
        int primeNumber = 213;
        int offset = 4;
        TransactionRecord tr = new TransactionRecord();
        
        try (RelativeFile outDataStream = new RelativeFile(inFile, primeNumber, recordLength);) {
            LineSequential.open(transactionFile, transactionFileStreamName, "input");
            while((inputLine = LineSequential.read(transactionFileStreamName)) != null) {
                makeTransactionRecord(inputLine, employeeRecordInMarks, tr);
                switch(tr.getTransactionCode()) {
                    case 1:
                        outDataStream.deleteRecord(tr.getEmployeeNumber());
                        break;
                    case 2:
                        outDataStream.addRecord(tr);
                        break;
                    case 3:
                        outDataStream.modifyField(tr.getEmployeeNumber(), offset, tr.getSales());
                        break;
                    default:
                        System.out.println("Transaction Code Invalid");
                        break;
                }
            }
            LineSequential.close(transactionFileStreamName, "input");
            System.out.println("File Complete");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    static void makeTransactionRecord(String inputLine, int [] employeeRecordInMarks, TransactionRecord tr) {
        tr.setEmployeeNumber(Integer.valueOf(inputLine.substring(0, employeeRecordInMarks[0])));
        tr.setSales(Integer.valueOf(inputLine.substring(employeeRecordInMarks[0], employeeRecordInMarks[1])));
        tr.setTransactionCode(Integer.valueOf(inputLine.substring(employeeRecordInMarks[1], employeeRecordInMarks[2])));
    }
}
