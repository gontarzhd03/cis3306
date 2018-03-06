package project1transaction;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import dao.LineSequential;

/**
 *
 * @author 55gontarhd03
 */
public class Project1Transaction {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String inFile = "./data/ProjectI.dat";
        String transactionFile = "./data/ProjectITransaction.dat";
        String transactionFileStreamName = "ProjectITransaction";
        String inputLine;
        int [] employeeRecordInMarks = {9, 15, 35, 41, 42};
        int recordLength = 32;
        int primeNumber = 271;
        int offsetSales = 4;
        int offsetRegion = 8;
        int offsetCommission = 28;
        TransactionRecord tr = new TransactionRecord();
        
        try (RelativeFile outDataStream = new RelativeFile(inFile, primeNumber, recordLength);) {
            LineSequential.open(transactionFile, transactionFileStreamName, "input");
            while((inputLine = LineSequential.read(transactionFileStreamName)) != null) {
                makeTransactionRecord(inputLine, employeeRecordInMarks, tr);
                int employeeNumber = tr.getEmployeeNumber();
                switch(tr.getTransactionCode()) {
                    case 1: //delete
                        outDataStream.deleteRecord(employeeNumber);
                        break;
                    case 2: //add
                        outDataStream.addRecord(tr.toBytes(), employeeNumber);
                        break;
                    case 3: //modify sales
                        outDataStream.modifyField(employeeNumber, offsetSales, tr.getSales());
                        break;
                    case 4: //modify region
                        outDataStream.modifyField(employeeNumber, offsetRegion, tr.getRegion());
                        break;
                    case 5: //modify commission
                        outDataStream.modifyField(employeeNumber, offsetCommission, tr.getCommission());
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
        tr.setRegion(inputLine.substring(employeeRecordInMarks[1], employeeRecordInMarks[2]));
        tr.setCommission(Float.valueOf(inputLine.substring(employeeRecordInMarks[2], employeeRecordInMarks[3])));
        tr.setTransactionCode(Integer.valueOf(inputLine.substring(employeeRecordInMarks[3], employeeRecordInMarks[4])));
    }
}
