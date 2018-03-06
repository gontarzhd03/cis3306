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
public class Frog extends Animal {

    public Frog(int idIn) {
        super(idIn, "Frog");
    }

    public Frog(int idIn, int weightIn) {
        super(idIn, weightIn, "Frog");
    }

    public Frog(int idIn, String nameIn) {
        super(idIn, nameIn);
    }

    public Frog(int idIn, int weightIn, String nameIn) {
        super(idIn, weightIn, nameIn);
    }
    public String hops() {
        return "Yes a frog hops";
    }
    @Override
    public String eats() {
        return "Yes a frog eats";
    }
    @Override
    public String scares(Animal animal2) {
        if(animal2 instanceof Frog) {
            if(this.getWeight() >= animal2.getWeight()) {
                return this.getName() + " scares " + animal2.getName();
            }
            else {
                return this.getName() + " fails to scares " + animal2.getName();
            }
        }
        if(animal2 instanceof Pig) {
            return this.getName() + " fails to scares " + animal2.getName();
        }
        if(animal2 instanceof Wolf) {
            return this.getName() + " fails to scares " + animal2.getName();
        }
        return "Animal type unknown";
    }
}
