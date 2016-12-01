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
import javax.sql.DataSource;

/**
 *
 * @author Jarretier Adrien "jarretier.adrien@gmail.com"
 */
public class StaffDao {

    private final DataSource myDataSource;

    private static final String staffTable = "staff";
    private static final String salt = "C0mpl1c at33d.";

    public StaffDao() throws SQLException {
        this.myDataSource = DS.getDataSource();
    }

    public Staff verify_login(String login, String password) throws SQLException, NoSuchAlgorithmException {

        MessageDigest md = MessageDigest.getInstance("SHA-256");

        String saltedPassword = password + salt;

        byte[] passwordBytes = saltedPassword.getBytes();
        byte[] passwordHashed = md.digest(passwordBytes);

        String sql = "SELECT * FROM " + staffTable + "where email = ?";
        Connection connection = myDataSource.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);

        stmt.setString(1, login);
        ResultSet rs = stmt.executeQuery();

        byte[] passwordStored = null;

        if (rs.next()) {
            passwordStored = rs.getBytes("password");

            // TODO get all row
        }

        rs.close();
        stmt.close();
        connection.close();

        if (Arrays.equals(passwordHashed, passwordStored)) {

            return new Staff();

        } else {
            // TODO throw exception
        }
    }

    public int addStaff(String email, String first_name, String last_name, String password, boolean is_admin) throws NoSuchAlgorithmException, SQLException {

        MessageDigest md = MessageDigest.getInstance("SHA-256");

        String saltedPassword = password + salt;

        byte[] passwordBytes = saltedPassword.getBytes();
        byte[] passwordHashed = md.digest(passwordBytes);

        String sql = "INSERT INTO " + staffTable + "(email, first_name, last_name, password, is_admin) VALUES(?, ?, ?, ?, ?)";
        Connection connection = myDataSource.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        stmt.setString(1, email);
        stmt.setString(2, first_name);
        stmt.setString(3, last_name);
        stmt.setBytes(4, passwordHashed);
        stmt.setBoolean(5, is_admin);
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
