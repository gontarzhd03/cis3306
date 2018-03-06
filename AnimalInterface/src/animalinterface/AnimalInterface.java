/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalinterface;

/**
 *
 * @author hgontarz
 */
public class AnimalInterface {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Wolf wolf1 = new Wolf(1, 26, "Wolf1");
        System.out.println(wolf1.getId());
        System.out.println(wolf1.getName());
        System.out.println(wolf1.getWeight());
        System.out.println(wolf1.getTailType());
        System.out.println(wolf1.eats());
        System.out.println("");
        
        Frog frog1 = new Frog(2, 5, "Frog1");
        System.out.println(frog1.getId());
        System.out.println(frog1.getName());
        System.out.println(frog1.getWeight());
        System.out.println(frog1.hops());
        System.out.println(frog1.eats());
        System.out.println("");
        
        Frog frog2 = new Frog(3, 6, "Frog2");
        System.out.println(frog2.getId());
        System.out.println(frog2.getName());
        System.out.println(frog2.getWeight());
        System.out.println(frog2.hops());
        System.out.println(frog2.eats());
        System.out.println("");
        
        Wolf wolf2 = new Wolf(4, 28, "Wolf2");
        System.out.println(wolf2.getId());
        System.out.println(wolf2.getName());
        System.out.println(wolf2.getWeight());
        System.out.println(wolf2.getTailType());
        System.out.println(wolf2.eats());
        System.out.println("");
        
        Pig pig1 = new Pig(5, 18, "Pig1");
        System.out.println(pig1.getId());
        System.out.println(pig1.getName());
        System.out.println(pig1.getWeight());
        System.out.println(pig1.getTailType());
        System.out.println(pig1.eats());
        System.out.println("");
        
        Pig pig2 = new Pig(6, 17, "Pig2");
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
