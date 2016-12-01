/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.sql.*;
/**
 *
 * @author Laurie
 */
public class Lesson {
    private int id;
    private Timestamp timeStart;
    private Timestamp timeEnd;
    private String title;
    private int classRoom;
    private int teacherId;

    public Lesson(int id, Timestamp timeStart, Timestamp timeEnd, String title, int class_room, int teacher_id) {
        this.id = id;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.title = title;
        this.classRoom = class_room;
        this.teacherId = teacher_id;
    }

    public int getId() {
        return id;
    }

    public Timestamp getTimeStart() {
        return timeStart;
    }

    public Timestamp getTimeEnd() {
        return timeEnd;
    }

    public String getTitle() {
        return title;
    }

    public int getClassRoom() {
        return classRoom;
    }

    public int getTeacherId() {
        return teacherId;
    }
    
    
    
}
