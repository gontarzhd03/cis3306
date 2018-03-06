/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeesserializable;
import dao.LineSequential;

/**
 *
 * @author 55gontarhd03
 */
public class PayrollSortWriter {
    public static void main(String[] args) {
        String inFile = "./data/PayrollMasterUnsorted.dat";
        String inFileStreamName = "PayrollMasterUnsorted";        
        String outFile = "./data/PayrollMasterSorted.dat";
        String outFileStreamName = "PayrollMasterSorted";
        int [] employeeRecordInMarks = {5, 25, 27, 29, 35, 79};
        String inputLine;        
        Employees employees = new Employees();

        initialization(inFile, inFileStreamName, outFile, outFileStreamName);
        while((inputLine = LineSequential.read(inFileStreamName)) != null) {
            moveFields(inputLine, employeeRecordInMarks, employees);
        }
        SerializeObjectToFile.setFileName("Employees.obj");
        SerializeObjectToFile.writeObjectToFile(employees);
        
        makePayrollMasterSorted(outFileStreamName, employees);
        terminationRoutine(inFileStreamName, outFileStreamName);
    }
    static void initialization(String inFile, String inFileStreamName, String outFile, String outFileStreamName) {
        LineSequential.open(inFile, inFileStreamName, "input");
        LineSequential.open(outFile, outFileStreamName, "output");
    }
    static void moveFields(String inputLine, int [] employeeRecordInMarks, Employees employees) {
        Employee employee = new Employee();
        initializeEmployeeFields(employee, inputLine, employeeRecordInMarks);
        employees.add(employee);
    }
    static void initializeEmployeeFields(Employee employee, String inputLine, int []employeeRecordInMarks) {
        employee.setTerritoryNumber(Integer.valueOf(inputLine.substring(employeeRecordInMarks[1], employeeRecordInMarks[2])));
        employee.setOtherInformation(inputLine);
    }
    static void makePayrollMasterSorted(String outFileStreamName, Employees employees) {
        employees.sort();
        for(int i = 0; i < employees.size(); i++) {
            LineSequential.write(outFileStreamName, (employees.get(i)).getOtherInformation());
        }
    }
    static void terminationRoutine(String inFileStreamName, String outFileStreamName) {
        LineSequential.close(inFileStreamName, "input");
        LineSequential.close(outFileStreamName, "output");
        System.out.println("File is complete.");
    }
}
