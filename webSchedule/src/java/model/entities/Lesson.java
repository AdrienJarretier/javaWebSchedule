/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entities;
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
    private int class_room_id;
    private int teacher_id;

    public Lesson(int id, Timestamp timeStart, Timestamp timeEnd, String title, int class_room_id, int teacher_id) {
        this.id = id;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.title = title;
        this.class_room_id = class_room_id;
        this.teacher_id = teacher_id;
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

    public int getClass_room_id() {
        return class_room_id;
    }

    public int getTeacher_id() {
        return teacher_id;
    }
    
    
    
}
