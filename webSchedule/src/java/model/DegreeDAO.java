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
import java.util.ArrayList;
import javax.sql.DataSource;
import model.entities.Class_room;
import model.entities.Degree;
import model.entities.Lesson;
import model.entities.Staff;

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

    public ArrayList<Degree> getDegrees() throws SQLException {

        String sql = "SELECT * FROM " + DEGREE_TABLE
                + " ORDER BY name";

        Connection connection = myDataSource.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        ArrayList<Degree> degrees = new ArrayList<>();

        while (rs.next()) {

            int id = rs.getInt("id");
            String name = rs.getString("name");
            int students_count = rs.getInt("students_count");

            Degree deg = new Degree(id, name, students_count);

            degrees.add(deg);

        }

        rs.close();
        stmt.close();
        connection.close();

        return degrees;

    }
    
    public Degree getById(int degree_id) throws SQLException, DAOException{
        String sql
                = " SELECT * FROM " + DEGREE_TABLE
                + " WHERE id = ?";

        Connection connection = myDataSource.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);

        stmt.setInt(1, degree_id);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            int students_count = rs.getInt("students_count");
           
            
            Degree deg = new Degree(id, name, students_count);

            rs.close();
            stmt.close();
            connection.close();

            return deg;

        } else {

            rs.close();
            stmt.close();
            connection.close();

            throw new DAOException("this id does not match any degree");
        }
    }

}
