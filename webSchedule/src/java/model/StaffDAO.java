package model;

import model.entities.Staff;
import model.entities.Class_room;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import javax.sql.DataSource;

/**
 *
 * @author Jarretier Adrien "jarretier.adrien@gmail.com"
 */
public class StaffDAO {
    
    private final DataSource myDataSource;
    
    private static final String STAFF_TABLE = "staff";
    private static final String SALT = "C0mpl1c at33d.";
    
    public StaffDAO() throws SQLException {
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
     * @throws DAOException if login error (either password or email invalid)
     */
    public Staff verify_login(String login, String password) throws SQLException, NoSuchAlgorithmException, DAOException {
        
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException ex) {
            throw new NoSuchAlgorithmException("SHA-256 isn't valid");
        }
        
        String saltedPassword = password + SALT;
        
        byte[] passwordBytes = saltedPassword.getBytes();
        byte[] passwordHashed = md.digest(passwordBytes);
        
        String sql = "SELECT * FROM " + STAFF_TABLE + " WHERE email = ?";
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
            
            rs.close();
            stmt.close();
            connection.close();
            
        } else {
            
            rs.close();
            stmt.close();
            connection.close();
            throw new DAOException("email does not match");
        }
        
        if (Arrays.equals(passwordHashed, passwordStored)) {
            
            return new Staff(id, email, lastName, firstName, isAdmin);
            
        } else {
            
            throw new DAOException("passwords do not match");
        }
    }

    /**
     *
     * @return the id of the inserted record
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
        
        String saltedPassword = password + SALT;
        
        byte[] passwordBytes = saltedPassword.getBytes();
        byte[] passwordHashed = md.digest(passwordBytes);
        
        String sql = "INSERT INTO " + STAFF_TABLE + "(email, first_name, last_name, password, is_admin) VALUES(?, ?, ?, ?, ?)";
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
    
    public void removeStaff(int id) throws SQLException {
        String sql = "DELETE FROM " + STAFF_TABLE + " WHERE id = ?";
        
        Connection connection = myDataSource.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.execute();
        stmt.close();
        connection.close();
    }

    /**
     *
     * @param staff_id
     * @return
     * @throws SQLException
     * @throws DAOException if id does not match any staff member
     */
    public Staff getById(int staff_id) throws SQLException, DAOException {
        
        String sql = "SELECT * FROM " + STAFF_TABLE + " WHERE id = ?";
        
        Connection connection = myDataSource.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        
        stmt.setInt(1, staff_id);
        ResultSet rs = stmt.executeQuery();
        
        Class_room cr = null;
        
        if (rs.next()) {
            
            int id = rs.getInt("id");
            String email = rs.getString("email");
            String first_name = rs.getString("first_name");
            String last_name = rs.getString("last_name");
            boolean is_admin = rs.getBoolean("is_admin");
            
            Staff st = new Staff(id, email, first_name, last_name, is_admin);
            
            rs.close();
            stmt.close();
            connection.close();
            
            return st;
            
        } else {
            
            rs.close();
            stmt.close();
            connection.close();
            
            throw new DAOException("this id does not match any staff member");
            
        }
    }
    
    private ArrayList<Staff> getTeachers() throws SQLException {
        
        String sql = "SELECT * FROM " + STAFF_TABLE + " WHERE is_admin=false";
        
        Connection connection = myDataSource.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        
        ArrayList<Staff> teachers = new ArrayList<>();
        
        while (rs.next()) {
            
            int id = rs.getInt("id");
            String email = rs.getString("email");
            String first_name = rs.getString("first_name");
            String last_name = rs.getString("last_name");
            
            teachers.add(new Staff(id, email, first_name, last_name, Boolean.FALSE));
            
        }
        
        rs.close();
        stmt.close();
        connection.close();
        
        return teachers;
    }
}
