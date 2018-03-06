package project1transaction;

import java.nio.ByteBuffer;

/**
 *
 * @author hgontarz
 */
public class Employee {
    private int employeeNumber;
    private int sales;
    private String region;
    private float commission;
    private int numberOfBytes = 32;
    
    public Employee() {
    }

    public Employee(int employeeNumberIn, int salesIn, String regionIn, float commissionIn) {
        employeeNumber = employeeNumberIn;
        sales = salesIn;
        region = regionIn;
        commission = commissionIn;
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

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public float getCommission() {
        return commission;
    }

    public void setCommission(float commission) {
        this.commission = commission;
    }
    
    public byte [] toBytes() {
        ByteBuffer aByteBuffer = ByteBuffer.allocate(numberOfBytes);
        aByteBuffer.putInt(employeeNumber);
        aByteBuffer.putInt(sales);
        aByteBuffer.put(region.getBytes());
        aByteBuffer.putFloat(commission);
        byte [] aByteArray = aByteBuffer.array();
        return aByteArray;
    }
}
