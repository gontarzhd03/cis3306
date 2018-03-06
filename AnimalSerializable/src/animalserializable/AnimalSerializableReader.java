/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalserializable;

/**
 *
 * @author 55gontarhd03
 */
public class AnimalSerializableReader {
    public static void main(String[] args) {
        SerializeObjectToFile.setFileName("wolf1.obj");
        Wolf wolf1 = (Wolf) SerializeObjectToFile.readObjectFromFile();
        System.out.println(wolf1.getId());
        System.out.println(wolf1.getName());
        System.out.println(wolf1.getWeight());
        System.out.println(wolf1.getTailType());
        System.out.println(wolf1.eats());
        System.out.println("");
        
        SerializeObjectToFile.setFileName("frog1.obj");
        Frog frog1 = (Frog) SerializeObjectToFile.readObjectFromFile();
        System.out.println(frog1.getId());
        System.out.println(frog1.getName());
        System.out.println(frog1.getWeight());
        System.out.println(frog1.hops());
        System.out.println(frog1.eats());
        System.out.println("");
        
        SerializeObjectToFile.setFileName("frog2.obj");
        Frog frog2 = (Frog) SerializeObjectToFile.readObjectFromFile();
        System.out.println(frog2.getId());
        System.out.println(frog2.getName());
        System.out.println(frog2.getWeight());
        System.out.println(frog2.hops());
        System.out.println(frog2.eats());
        System.out.println("");
        
        SerializeObjectToFile.setFileName("wolf2.obj");
        Wolf wolf2 = (Wolf) SerializeObjectToFile.readObjectFromFile();
        System.out.println(wolf2.getId());
        System.out.println(wolf2.getName());
        System.out.println(wolf2.getWeight());
        System.out.println(wolf2.getTailType());
        System.out.println(wolf2.eats());
        System.out.println("");
        
        SerializeObjectToFile.setFileName("pig1.obj");
        Pig pig1 = (Pig) SerializeObjectToFile.readObjectFromFile();
        System.out.println(pig1.getId());
        System.out.println(pig1.getName());
        System.out.println(pig1.getWeight());
        System.out.println(pig1.getTailType());
        System.out.println(pig1.eats());
        System.out.println("");
        
        SerializeObjectToFile.setFileName("pig2.obj");
        Pig pig2 = (Pig) SerializeObjectToFile.readObjectFromFile();
        System.out.println(pig2.getId());
        System.out.println(pig2.getName());
        System.out.println(pig2.getWeight());
        System.out.println(pig2.getTailType());
        System.out.println(pig2.eats());
        System.out.println("");
        
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
