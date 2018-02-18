/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeesalesrelativetransaction;

/**
 *
 * @author hgontarz
 */
public class TransactionRecord extends Employee {
    private int transactionCode;

    /**
     * 
     * @return transactionCode
     */
    public int getTransactionCode() {
        return transactionCode;
    }

    /**
     * 
     * @param transactionCode 
     */
    public void setTransactionCode(int transactionCode) {
        this.transactionCode = transactionCode;
    }
}
