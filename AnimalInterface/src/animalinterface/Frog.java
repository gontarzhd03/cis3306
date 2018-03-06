/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalinterface;

/**
 *
 * @author 55gontarhd03
 */
public class Frog implements Animal {
    private String name;
    private int weight;
    private int id;
    
    public Frog(int idIn) {
        id = idIn;
        weight = 0;
        name = "Frog";
    }

    public Frog(int idIn, int weightIn) {
        id = idIn;
        weight = weightIn;
        name = "Frog";
    }

    public Frog(int idIn, String nameIn) {
        id = idIn;
        weight = 0;
        name = nameIn;
    }

    public Frog(int idIn, int weightIn, String nameIn) {
        id = idIn;
        weight = weightIn;
        name = nameIn;
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
            if(weight >= animal2.getWeight()) {
                return name + " scares " + animal2.getName();
            }
            else {
                return name + " fails to scares " + animal2.getName();
            }
        }
        if(animal2 instanceof Pig) {
            return name + " fails to scares " + animal2.getName();
        }
        if(animal2 instanceof Wolf) {
            return name + " fails to scares " + animal2.getName();
        }
        return "Animal type unknown";
    }
    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public void setName(String nameIn) {
        name = nameIn;
    }
    
    @Override
    public int getWeight() {
        return weight;
    }

    @Override
    public void setWeight(int weightIn) {
        weight = weightIn;
    }
    
    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int idIn) {
        id = idIn;
    }
}
