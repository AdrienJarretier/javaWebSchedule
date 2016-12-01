/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import javax.sql.DataSource;

/**
 *
 * @author Jarretier Adrien "jarretier.adrien@gmail.com"
 */
public class LessonDAO {
    private final DataSource myDataSource;

    private static final String lessonTable = "lesson";
    
    public LessonDAO() throws SQLException {
        this.myDataSource = DS.getDataSource();
    }
    
    /**
     * insert a new lesson in the database
     *
     * @param lesson the lesson to insert in the db
     * @return the id of the inserted row
     */
    public int add(Lesson lesson) throws SQLException {
        String sql = "INSERT INTO " + lessonTable + 
                     "(time_start, time_end, title, class_room, teacher_id)" 
                 + "VALUES (?,?,?,?,?)";
        
        Connection connection = myDataSource.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);

        stmt.setTimestamp(1, lesson.getTimeStart());
        stmt.setTimestamp(2, lesson.getTimeEnd());
        stmt.setString(3, lesson.getTitle());
        stmt.setInt(4, lesson.getClassRoom());
        stmt.setInt(5, lesson.getTeacherId());
        stmt.execute();
        
        ResultSet generatedKeys = stmt.getGeneratedKeys();

        int generatedId = 0;

        if (generatedKeys.next()) {
            generatedId = generatedKeys.getInt(1);
        }

        generatedKeys.close();
        stmt.close();
        connection.close();

        return generatedId;
    }

    /**
     * delete the lesson with the specified id
     *
     * @param lessonId the id of the lesson to delete
     */
    public void remove(int lessonId) {

    }

    /**
     * delete the lesson happening at time_start in class_room
     *
     * @param time_start
     * @param class_room
     */
    public void remove(Timestamp time_start, Class_room class_room) {

    }

    /**
     * delete the lesson happening at time_start with teacher
     *
     * @param time_start
     * @param teacher
     */
    public void remove(Timestamp time_start, Staff teacher) {

    }

    /**
     * update lesson in the database looks for the id of the lesson and update
     * all the columns for that record to match the lesson entity attributes
     *
     * @param lesson the lesson to be recorded
     */
    public void edit(Lesson lesson) {

    }

    /**
     *
     * get the schedule of a teacher
     *
     * @param time_start
     * @param time_end
     * @param teacher
     * @return
     */
    public ArrayList<Lesson> getSchedule(Timestamp time_start, Timestamp time_end, Staff teacher) {

    }

    /**
     *
     * get the schedule for a degree
     *
     * @param time_start
     * @param time_end
     * @param degree
     * @return
     */
    public ArrayList<Lesson> getSchedule(Timestamp time_start, Timestamp time_end, Degree degree) {

    }

    /**
     *
     * get the schedule of a class room
     *
     * @param time_start
     * @param time_end
     * @param class_room
     * @return
     */
    public ArrayList<Lesson> getSchedule(Timestamp time_start, Timestamp time_end, Class_room class_room) {

    }
}
