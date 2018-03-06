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
interface Animal  {
    public abstract String scares(Animal animal2);
    
    public abstract String eats();
    
    public abstract String getName();
    
    public abstract void setName(String name);
    
    public abstract int getWeight();

    public abstract void setWeight(int weight);
    
    public abstract int getId();

    public abstract void setId(int id);
}
