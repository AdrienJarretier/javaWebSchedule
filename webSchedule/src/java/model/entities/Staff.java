/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entities;

/**
 *
 * @author Jarretier Adrien "jarretier.adrien@gmail.com"
 */
public class Staff {
    private int id ; 
    private String email; 
    private String firstName ; 
    private String lastName ; 
    private Boolean isAdmin ; 
    
    public Staff(int id, String email, String firstName, String lastName, Boolean isAdmin ){
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isAdmin = isAdmin ; 
    }
    
    public int getId (){
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Boolean getIsAdmin() {
        return isAdmin;
    }
}
