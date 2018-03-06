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
public class Wolf extends Animal {
    private String tailType = "Long";
 
    public Wolf(int idIn) {
        super(idIn, "Wolf");
    }

    public Wolf(int idIn, int weightIn) {
        super(idIn, weightIn, "Wolf");
    }

    public Wolf(int idIn, String nameIn) {
        super(idIn, nameIn);
    }

    public Wolf(int idIn, int weightIn, String nameIn) {
        super(idIn, weightIn, nameIn);
    }
    
    @Override
    public String scares(Animal animal2) {
        if(animal2 instanceof Frog) {
            return this.getName() + " scares " + animal2.getName();
        }
        if(animal2 instanceof Pig) {
            return this.getName() + " scares " + animal2.getName();
        }
        if(animal2 instanceof Wolf) {
            if(this.getWeight() >= animal2.getWeight()) {
                return this.getName() + " scares " + animal2.getName();
            }
            else {
                return this.getName() + " fails to scares " + animal2.getName();
            }
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
