/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeesalesrelativemodify;

import java.nio.ByteBuffer;

/**
 *
 * @author hgontarz
 */
public class Employee {
    private int employeeNumber;
    private int sales;
    private int numberOfBytes = 8;

    public Employee() {
    }

    public Employee(int employeeNumberIn, int salesIn) {
        this.employeeNumber = employeeNumberIn;
        this.sales = salesIn;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public int getNumberOfBytes() {
        return numberOfBytes;
    }

    public void setNumberOfBytes(int numberOfBytes) {
        this.numberOfBytes = numberOfBytes;
    }
    
    public byte [] toBytes() {
        ByteBuffer aByteBuffer = ByteBuffer.allocate(numberOfBytes);
        aByteBuffer.putInt(employeeNumber);
        aByteBuffer.putInt(sales);
        byte [] aByteArray = aByteBuffer.array();
        return aByteArray;
    }
}
