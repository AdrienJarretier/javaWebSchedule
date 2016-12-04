/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import model.entities.Degree;

/**
 *
 * @author Jarretier Adrien "jarretier.adrien@gmail.com"
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        
//        SELECT * FROM LESSON
//INNER JOIN class_room ON class_room.id=LESSON.CLASS_ROOM_ID
//INNER JOIN staff ON staff.id=LESSON.TEACHER_ID
//INNER JOIN LESSON_PARTICIPANTS ON LESSON_PARTICIPANTS.LESSON_ID = LESSON.ID
//INNER JOIN DEGREE on LESSON_PARTICIPANTS.DEGREE_ID = DEGREE.ID
//WHERE lesson.ID = 6;

        
        LessonDAO lDAO = new LessonDAO();
        
//        ArrayList<Degree> participants = new ArrayList<>();
//        
//        participants.add(new Degree(3, "L3 Mathématiques", 128));
//        participants.add(new Degree(5, "L3 informatique", 28));
//        
//        lDAO.add(Timestamp.valueOf("2016-12-04 18:0:0"), Timestamp.valueOf("2016-12-04 19:0:0"), "add test", 3, 2, participants);
        
        lDAO.remove(6);
        
    }
    
}
