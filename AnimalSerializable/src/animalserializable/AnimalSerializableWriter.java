/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalserializable;

/**
 *
 * @author hgontarz
 */
public class AnimalSerializableWriter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Wolf wolf1 = new Wolf(1, 26, "Wolf1");
        SerializeObjectToFile.setFileName("wolf1.obj");
        SerializeObjectToFile.writeObjectToFile(wolf1);
        
        Frog frog1 = new Frog(2, 5, "Frog1");
        SerializeObjectToFile.setFileName("frog1.obj");
        SerializeObjectToFile.writeObjectToFile(frog1);
      
        Frog frog2 = new Frog(3, 6, "Frog2");
        SerializeObjectToFile.setFileName("frog2.obj");
        SerializeObjectToFile.writeObjectToFile(frog2);
        
        Wolf wolf2 = new Wolf(4, 28, "Wolf2");
        SerializeObjectToFile.setFileName("wolf2.obj");
        SerializeObjectToFile.writeObjectToFile(wolf2);
        
        Pig pig1 = new Pig(5, 18, "Pig1");
        SerializeObjectToFile.setFileName("pig1.obj");
        SerializeObjectToFile.writeObjectToFile(pig1);
        
        Pig pig2 = new Pig(6, 17, "Pig2");
        SerializeObjectToFile.setFileName("pig2.obj");
        SerializeObjectToFile.writeObjectToFile(pig2);
        
        System.out.println(frog1.scares(wolf1));
        System.out.println(frog1.scares(frog2));
        System.out.println(frog2.scares(frog1));
        System.out.println(wolf1.scares(frog1));
        System.out.println(wolf1.scares(wolf2));
        System.out.println(wolf2.scares(wolf1));
        System.out.println(frog1.scares(pig1));
        System.out.println(wolf1.scares(pig1));
        System.out.println(pig1.scares(wolf1));
        System.out.println(pig1.scares(frog1));
        System.out.println(pig1.scares(pig2));
        System.out.println(pig2.scares(pig1));
    }
    
}
