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
    private int class_room;
    private int teacher_id;

    public Lesson(int id, Timestamp timeStart, Timestamp timeEnd, String title, int class_room, int teacher_id) {
        this.id = id;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.title = title;
        this.class_room = class_room;
        this.teacher_id = teacher_id;
    }
    
    
    
}
