/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Jarretier Adrien "jarretier.adrien@gmail.com"
 */
public class UserDao {
    
    private UserDao() {
    }
    
    public static UserDao getInstance() {
        return UserDaoHolder.INSTANCE;
    }
    
    private static class UserDaoHolder {

        private static final UserDao INSTANCE = new UserDao();
    }
}
