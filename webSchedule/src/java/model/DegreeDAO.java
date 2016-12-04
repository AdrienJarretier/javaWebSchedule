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
public class DegreeDAO {

    private final DataSource myDataSource;

    private static final String DEGREE_TABLE = "degree";
    private static final String PARTICIPANTS_TABLE = "lesson_participants";

    public DegreeDAO() throws SQLException {
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

}
