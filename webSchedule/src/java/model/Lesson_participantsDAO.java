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
import java.util.ArrayList;
import javax.sql.DataSource;
import model.entities.Degree;

/**
 *
 * @author Jarretier Adrien "jarretier.adrien@gmail.com"
 */
public class Lesson_participantsDAO {

    private final DataSource myDataSource;

    private static final String DEGREE_TABLE = "degree";
    private static final String PARTICIPANTS_TABLE = "lesson_participants";

    public Lesson_participantsDAO() throws SQLException {
        this.myDataSource = DS.getDataSource();
    }

    public ArrayList<Degree> getParticipants(int lesson_id) throws SQLException {
        String sql
                = "SELECT id, name, students_count "
                + " FROM " + PARTICIPANTS_TABLE
                + " INNER JOIN " + DEGREE_TABLE
                + " ON " + PARTICIPANTS_TABLE + ".degree_id = " + DEGREE_TABLE + ".id"
                + " WHERE lesson_id = ?";
        Connection connection = myDataSource.getConnection();
        PreparedStatement partsStmt = connection.prepareStatement(sql);

        partsStmt.setInt(1, lesson_id);
        ResultSet partsRS = partsStmt.executeQuery();

        // for each result, fill participants
        ArrayList<Degree> participants = new ArrayList<>();

        while (partsRS.next()) {

            int degree_id = partsRS.getInt("id");
            String degree_name = partsRS.getString("name");
            int students_count = partsRS.getInt("students_count");

            participants.add(new Degree(degree_id, degree_name, students_count));

        }

        partsRS.close();
        partsStmt.close();
        connection.close();

        return participants;
    }

    /**
     * insert all participants of the lesson in the table lesson_participants
     *
     * @param participants the list of degrees that will attend the lesson
     * @param lessonId the id of the lesson to attend
     */
    void add(ArrayList<Degree> participants, int lessonId) throws SQLException {

        String sql = "INSERT INTO " + PARTICIPANTS_TABLE
                + "(degree_id, lesson_id)"
                + " VALUES (?, ?)";

        Connection connection = myDataSource.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);

        for (Degree participant : participants) {

            stmt.setInt(1, participant.getId());
            stmt.setInt(2, lessonId);
            stmt.execute();
        }

        stmt.close();
        connection.close();

    }

    /**
     * Removes all participants from a lesson
     *
     * @param lessonId the id of the lesson from witch all participants should
     * be removed
     */
    void remove(int lessonId) throws SQLException {

        String sql = "DELETE FROM " + PARTICIPANTS_TABLE
                + " WHERE lesson_id = ? ";

        Connection connection = myDataSource.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);

        stmt.setInt(1, lessonId);
        stmt.execute();
        stmt.close();
        connection.close();

    }

}
