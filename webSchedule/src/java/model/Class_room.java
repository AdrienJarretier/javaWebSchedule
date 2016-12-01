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
public class Class_room {
    
    private int id;
    private String building;
    private int room_number;
    private int capacity;

    public Class_room(int id, String building, int room_number, int capacity) {
        this.id = id;
        this.building = building;
        this.room_number = room_number;
        this.capacity = capacity;
    }

    public int getId() {
        return id;
    }

    public String getBuilding() {
        return building;
    }

    public int getRoom_number() {
        return room_number;
    }

    public int getCapacity() {
        return capacity;
    }
    
}
