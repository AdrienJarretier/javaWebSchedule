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

    /**
     * attempts to match the credentials with a staff member in the db if ok
     * returns the staff entity if not, raises an exception
     *
     * @param login
     * @param password
     * @return the staff entity with these credentials
     * @throws SQLException
     * @throws NoSuchAlgorithmException if SHA-256 isn't valid
     * @throws Exception if login error (either password or email invalid)
     */
    public Staff verify_login(String login, String password) throws SQLException, NoSuchAlgorithmException, Exception {

        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException ex) {
            throw new NoSuchAlgorithmException("SHA-256 isn't valid");
        }

        String saltedPassword = password + salt;

        byte[] passwordBytes = saltedPassword.getBytes();
        byte[] passwordHashed = md.digest(passwordBytes);

        String sql = "SELECT * FROM " + staffTable + "where email = ?";
        Connection connection = myDataSource.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);

        stmt.setString(1, login);
        ResultSet rs = stmt.executeQuery();

        byte[] passwordStored;
        int id;
        String email;
        String lastName;
        String firstName;
        boolean isAdmin;

        if (rs.next()) {
            passwordStored = rs.getBytes("password");
            id = rs.getInt("id");
            email = rs.getString("email");
            lastName = rs.getString("last_name");
            firstName = rs.getString("first_name");
            isAdmin = rs.getBoolean("is_admin");

        } else {
            throw new Exception("email does not match");
        }

        rs.close();
        stmt.close();
        connection.close();

        if (Arrays.equals(passwordHashed, passwordStored)) {

            return new Staff(id, email, lastName, firstName, isAdmin);

        } else {

            throw new Exception("passwords do not match");
        }
    }

    /**
     *
     * @param email
     * @param first_name
     * @param last_name
     * @param password
     * @param is_admin
     * @return
     * @throws NoSuchAlgorithmException if SHA-256 isn't valid
     * @throws SQLException
     */
    public int addStaff(String email, String first_name, String last_name, String password, boolean is_admin) throws NoSuchAlgorithmException, SQLException {

        MessageDigest md;

        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException ex) {
            throw new NoSuchAlgorithmException("SHA-256 isn't valid");
        }

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
    
    public void removeStaff (int id) throws SQLException{
        String sql = "DELETE FROM " + staffTable + "WHERE id = ?";
        
        Connection connection = myDataSource.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.execute();
        stmt.close();
        connection.close();
    }
}
