/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalinheritance;

/**
 *
 * @author 55gontarhd03
 */
public class Pig extends Animal {
    private String tailType = "Curly";
 
    public Pig(int idIn) {
        super(idIn, "Pig");
    }

    public Pig(int idIn, int weightIn) {
        super(idIn, weightIn, "Pig");
    }

    public Pig(int idIn, String nameIn) {
        super(idIn, nameIn);
    }

    public Pig(int idIn, int weightIn, String nameIn) {
        super(idIn, weightIn, nameIn);
    }
    
    @Override
    public String scares(Animal animal2) {
        if(animal2 instanceof Frog) {
            return this.getName() + " scares " + animal2.getName();
        }
        if(animal2 instanceof Pig) {
            if(this.getWeight() >= animal2.getWeight()) {
                return this.getName() + " scares " + animal2.getName();
            }
            else {
                return this.getName() + " fails to scares " + animal2.getName();
            }
        }
        if(animal2 instanceof Wolf) {
            return this.getName() + " fails to scares " + animal2.getName();
        }
        return "Animal type unknown";
    }

    public String getTailType() {
        return tailType;
    }

    public void setTailType(String tailType) {
        this.tailType = tailType;
    }
}
