/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalinheritance;
import java.io.*;
/**
 *
 * @author hgontarz
 */
public class Animal implements Serializable {
    private String name;
    private int weight;
    private int id;

    public Animal(int idIn) {
        id = idIn;
        weight = 0;
        name = "Animal";
    }

    public Animal(int idIn, int weightIn) {
        id = idIn;
        weight = weightIn;
        name = "Animal";
    }

    public Animal(int idIn, String nameIn) {
        id = idIn;
        weight = 0;
        name = nameIn;
    }

    public Animal(int idIn, int weightIn, String nameIn) {
        id = idIn;
        weight = weightIn;
        name = nameIn;
    }
    
    public String scares(Animal animal2) {
        return "Unknown Animal Type";
    }
    
    public String eats() {
        return "Yes an animal eats";
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
