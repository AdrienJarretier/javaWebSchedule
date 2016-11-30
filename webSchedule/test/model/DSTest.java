/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Laurie
 */
public class DSTest {
    
    public DSTest() {
    }
    
    @Before
    public void setUp() {
    }

    /**
     * Test of getDataSource method, of class DS.
     */
    @Test
    public void testGetDataSource() throws Exception {
        System.out.println("getDataSource");
        try{
            DataSource result = DS.getDataSource();
            Connection connection = result.getConnection();
            
            assertTrue(connection.isValid(0));
            
            connection.close();
            
        } catch (SQLException e){
            fail(e.getMessage());
        }
        
    }
    
}
