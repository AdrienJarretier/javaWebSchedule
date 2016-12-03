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
class Class_roomDAO {
    
    private final DataSource myDataSource;

    private static final String CLASS_ROOM_TABLE = "class_room";

    public Class_roomDAO() throws SQLException {
        this.myDataSource = DS.getDataSource();
    }

    /**
     * Returns the Class_room with this id foudn in the database
     * 
     * @param class_room_id the id of the requested class room
     * @return a Class_room entity
     * @throws SQLException
     * @throws Exception if no class room in the db matches with that id
     */
    Class_room getById(int class_room_id) throws SQLException, Exception {
        
        String sql = "SELECT * FROM " + CLASS_ROOM_TABLE + " WHERE id = ?";
        
        Connection connection = myDataSource.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        
        stmt.setInt(1, class_room_id);
        ResultSet rs = stmt.executeQuery();
        
        Class_room cr = null;
        
        rs.close();
        stmt.close();
        connection.close();
        
        if(rs.next()) {

            int id = rs.getInt("id");
            String building = rs.getString("building");
            int room_nb = rs.getInt("room_nb");
            int capacity = rs.getInt("capacity");

            cr = new Class_room(id, building, room_nb, capacity);

            return cr;

        }
        else {
            
            throw new Exception("this id does not match any class room");
            
        }
    }
    
}