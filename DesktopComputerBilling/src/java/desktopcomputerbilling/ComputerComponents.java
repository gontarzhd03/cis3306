/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desktopcomputerbilling;

/**
 *
 * @author 55gontarhd03
 */
public class ComputerComponents {
    private String processor;
    private int processorPrice;
    private String drive;
    private int drivePrice;
    private int totalPrice;

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public int getProcessorPrice() {
        return processorPrice;
    }

    public void setProcessorPrice(int processorPrice) {
        this.processorPrice = processorPrice;
    }

    public String getDrive() {
        return drive;
    }

    public void setDrive(String drive) {
        this.drive = drive;
    }

    public int getDrivePrice() {
        return drivePrice;
    }

    public void setDrivePrice(int drivePrice) {
        this.drivePrice = drivePrice;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
   
}
