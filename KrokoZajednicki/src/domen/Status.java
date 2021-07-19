/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

/**
 *
 * @author KOMP
 */
public enum Status {
    GUSTER("Gušter"),
    ALIGATOR("Aligaotr"),
    KROKODIL("Krokodil");
    
    String status;

    private Status(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return status;
    }
    
    public static Status getName(String value){
        for (Status status : Status.values()) {
            if(status.toString().equals(value)){
            return status;
            }
        }
        return null;
    }
}
