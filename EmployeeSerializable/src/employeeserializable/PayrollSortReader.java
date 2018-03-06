/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeeserializable;
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
        Employees employees = new Employees();
        Employee employee;
        
        LineSequential.open(outFile, outFileStreamName, "output");
        for(int i = 1; i < 21; i++) {
            SerializeObjectToFile.setFileName("Employee" + String.valueOf(i).trim() + ".obj");
            employee = (Employee) SerializeObjectToFile.readObjectFromFile();
            employees.add(employee);
        }
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
