/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Jarretier Adrien "jarretier.adrien@gmail.com"
 */
public class Staff {
    int id ; 
    String email; 
    String firstName ; 
    String lastName ; 
    Boolean isAdmin ; 
    
    public Staff(int id, String email, String firstName, String lastName, Boolean isAdmin ){
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isAdmin = isAdmin ; 
    }
}
