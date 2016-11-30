/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Laurie
 */
public class UserDaoTest {
    
    public UserDaoTest() {
    }
    
    @Before
    public void setUp() {
    }

    /**
     * Test of verify_login method, of class UserDao.
     */
    @Test
    public void testVerify_login() throws Exception {
        System.out.println("verify_login");
        String login = "";
        String password = "";
        UserDao instance = new UserDao();
        User expResult = null;
        User result = instance.verify_login(login, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
