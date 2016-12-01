/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.Arrays;

/**
 *
 * @author Jarretier Adrien "jarretier.adrien@gmail.com"
 */
public class UserDao {

    private final DataSource myDataSource;

    public UserDao() throws SQLException {
        this.myDataSource = DS.getDataSource();
    }

    public User verify_login(String login, String password) throws SQLException, NoSuchAlgorithmException {

        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] passwordBytes = password.getBytes();
        byte[] passwordHashed = md.digest(passwordBytes);

        String sql = "SELECT password FROM testpasshash";
        Connection connection = myDataSource.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);

        ResultSet rs = stmt.executeQuery();

        byte[] passwordStored = null;

        if (rs.next()) {
            passwordStored = rs.getBytes(1);
        }

        rs.close();
        stmt.close();
        connection.close();

        if (Arrays.equals(passwordHashed, passwordStored)  {

            return new User();
        } else {
            // TODO throw exception
        }
    }
    
    public int addStaff(String email, String first_name, String last_name, String password, boolean is_admin) throws NoSuchAlgorithmException, SQLException {

        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] passwordBytes = password.getBytes();
        byte[] passwordHashed = md.digest(passwordBytes);

        String sql = "INSERT INTO staff(email, first_name, last_name, password, is_admin) VALUES(?, ?, ?, ?, ?)";
        Connection connection = myDataSource.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        
        stmt.setBytes(4, passwordHashed);
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
}
