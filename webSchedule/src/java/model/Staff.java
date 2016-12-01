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
    int idS ; 
    String emailS ; 
    String firstNameS ; 
    String lastNameS ; 
    Boolean isAdminS ; 
    
    public Staff(int id, String email, String firstName, String lastName, Boolean isAdmin ){
        idS = id;
        emailS = email;
        firstNameS = firstName;
        lastNameS = lastName;
        isAdminS = isAdmin ; 
    }
}
