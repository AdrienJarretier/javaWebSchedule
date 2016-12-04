/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entities;

import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Laurie
 */
public class Lesson {

    private int id;
    private Timestamp timeStart;
    private Timestamp timeEnd;
    private String title;
    private Class_room class_room;
    private Staff teacher;

    private ArrayList<Degree> participants;

    public Lesson(int id, Timestamp timeStart, Timestamp timeEnd, String title, Class_room class_room, Staff teacher, ArrayList<Degree> participants) {
        this.id = id;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.title = title;
        this.class_room = class_room;
        this.teacher = teacher;
        this.participants = participants;
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

    public Class_room getClass_room() {
        return class_room;
    }

    public Staff getTeacher() {
        return teacher;
    }

    public ArrayList<Degree> getParticipants() {
        return participants;
    }

}
