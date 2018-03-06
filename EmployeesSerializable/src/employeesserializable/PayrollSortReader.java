/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeesserializable;
import dao.LineSequential;

/**
 *
 * @author hgontarz
 */
public class PayrollSortReader {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String outFile = "./data/PayrollMasterSortedFromObjects.dat";
        String outFileStreamName = "PayrollMasterSorted";

        LineSequential.open(outFile, outFileStreamName, "output");
        SerializeObjectToFile.setFileName("Employees.obj");
        Employees employees = (Employees) SerializeObjectToFile.readObjectFromFile();

        makePayrollMasterSorter(outFileStreamName, employees);
        terminationRoutine(outFileStreamName);
    }
    static void makePayrollMasterSorter(String outFileStreamName, Employees employees) {
        employees.sort();
        for(int i = 0; i < employees.size(); i++) {
            LineSequential.write(outFileStreamName, (employees.get(i)).getOtherInformation());
        }
    }
    static void terminationRoutine(String outFileStreamName) {
        LineSequential.close(outFileStreamName, "output");
        System.out.println("File is Complete");
    }
}
