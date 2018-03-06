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
public class Wolf implements Animal {
    private String name;
    private int weight;
    private int id;
    private String tailType = "Long";
         
    public Wolf(int idIn) {
        id = idIn;
        weight = 0;
        name = "Wolf";
    }

    public Wolf(int idIn, int weightIn) {
        id = idIn;
        weight = weightIn;
        name = "Wolf";
    }

    public Wolf(int idIn, String nameIn) {
        id = idIn;
        weight = 0;
        name = nameIn;
    }

    public Wolf(int idIn, int weightIn, String nameIn) {
        id = idIn;
        weight = weightIn;
        name = nameIn;
    }
    
    @Override
    public String scares(Animal animal2) {
        if(animal2 instanceof Frog) {
            return name + " scares " + animal2.getName();
        }
        if(animal2 instanceof Pig) {
            return name + " scares " + animal2.getName();
        }
        if(animal2 instanceof Wolf) {
            if(weight >= animal2.getWeight()) {
                return name + " scares " + animal2.getName();
            }
            else {
                return name + " fails to scares " + animal2.getName();
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
    @Override
    public String eats() {
        return "Yes a wolf eats";
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
