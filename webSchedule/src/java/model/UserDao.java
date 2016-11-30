/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

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

    public User verify_login(String login, String mp){
        
    }
}
