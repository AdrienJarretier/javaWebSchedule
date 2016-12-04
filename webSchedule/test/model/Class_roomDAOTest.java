/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.entities.Class_room;
import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jarretier Adrien "jarretier.adrien@gmail.com"
 */
public class Class_roomDAOTest {

    private Class_roomDAO instance;

    public Class_roomDAOTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws SQLException {

        instance = new Class_roomDAO();

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getById method, of class Class_roomDAO.
     */
    @Test
    public void testGetById() throws Exception {
        System.out.println("getById");
        int class_room_id = 2;

        Class_room result = instance.getById(class_room_id);
        assertEquals(2, result.getId());
        assertEquals("Borel", result.getBuilding());
        assertEquals(215, result.getRoom_number());
        assertEquals(35, result.getCapacity());
    }

}
