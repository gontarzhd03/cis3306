/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeeserializable;

import java.io.Serializable;

/**
 *
 * @author hgontarz
 */
public class Employee implements Comparable, Serializable {
    private int territoryNumber;
    private String otherInformation;

    public int getTerritoryNumber() {
        return territoryNumber;
    }

    public void setTerritoryNumber(int territoryNumber) {
        this.territoryNumber = territoryNumber;
    }

    public String getOtherInformation() {
        return otherInformation;
    }

    public void setOtherInformation(String otherInformation) {
        this.otherInformation = otherInformation;
    }

    @Override
    public int compareTo(Object employee) {
        if(territoryNumber > ((Employee)employee).getTerritoryNumber()) {
            return 0;
        }
        else {
            if(territoryNumber > ((Employee)employee).getTerritoryNumber()) {
                return 1;
            }
            else {
                return -1;
            }
        }
    }
    
}
