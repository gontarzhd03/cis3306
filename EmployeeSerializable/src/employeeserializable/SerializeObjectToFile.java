/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeeserializable;

import java.io.*;

/**
 *
 * @author 55gontarhd03
 */
public class SerializeObjectToFile {
    private static String fileName;

    public SerializeObjectToFile(String fileNameIn) {
        fileName = fileNameIn;
    }
    public static void writeObjectToFile(Object object1) {
        try(ObjectOutputStream fileout1 = new ObjectOutputStream(new FileOutputStream(fileName));) {
            fileout1.writeObject(object1);
        }
        catch(IOException e) {
            System.out.println("I O Exception");
        }
    }
    public static Object readObjectFromFile() {
        try(ObjectInputStream fileout1 = new ObjectInputStream(new FileInputStream(fileName));) {
            return fileout1.readObject();
        }
        catch(IOException e) {
            System.out.println("I O Exception");
            return null;
        }
        catch(ClassNotFoundException e) {
            System.out.println("I O Exception");
            return null;
        }
    }
    
    public static String getFileName() {
        return fileName;
    }

    public static void setFileName(String aFileName) {
        fileName = aFileName;
    }
}
