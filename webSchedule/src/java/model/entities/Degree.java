/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entities;

import java.util.Objects;

/**
 *
 * @author Jarretier Adrien "jarretier.adrien@gmail.com"
 */
public class Degree {

    private int id;
    private String name;
    private int student_count;

    public Degree(int id, String name, int student_count) {
        this.id = id;
        this.name = name;
        this.student_count = student_count;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getStudent_count() {
        return student_count;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Degree other = (Degree) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.student_count != other.student_count) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    

}
