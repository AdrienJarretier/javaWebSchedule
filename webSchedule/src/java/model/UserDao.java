/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;

/**
 *
 * @author Jarretier Adrien "jarretier.adrien@gmail.com"
 */
public class UserDao {

    private final DataSource myDataSource;

    public UserDao() throws SQLException {
        this.myDataSource = DS.getDataSource();
    }

    public User verify_login(String login, String password) throws SQLException, NoSuchAlgorithmException{
        String sql = "SELECT MP FROM STAFF WHERE EMAIL = ? ";
        Connection connection = myDataSource.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        
        stmt.setString(1,login);
        ResultSet rs = stmt.executeQuery();
        
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] tab_log = login.getBytes();
        byte[] log_encrypt = md.digest(tab_log);
        
       
        
    }
}
