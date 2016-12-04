/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.entities.Degree;
import model.entities.Staff;
import model.entities.Class_room;
import model.entities.Lesson;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
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
public class LessonDAOTest {

    private LessonDAO instance;

    public LessonDAOTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws SQLException {

        instance = new LessonDAO();

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of add method, of class LessonDAO.
     */
    @Test
    public void testAddAndRemove() {
        System.out.println("add and remove");

        Timestamp start = Timestamp.valueOf("2016-12-25 00:00:00");
        Timestamp end = Timestamp.valueOf("2016-12-25 01:00:00");
        String title = "Santa Claus course";
        int class_room_id = 2;
        int teacher_id = 3;

        try {
            int idInserted = instance.add(start, end, title, class_room_id, teacher_id);

            System.out.println("idInserted : " + idInserted);

            instance.remove(idInserted);

        } catch (SQLException ex) {
            fail("SQLException : " + ex.getMessage());
        }
    }

    /**
     * Test of remove method, of class LessonDAO.
     */
    @Test
    public void testRemove_Timestamp_Class_room() {
        System.out.println("remove");

        Timestamp start = Timestamp.valueOf("2016-12-25 00:00:00");
        Timestamp end = Timestamp.valueOf("2016-12-25 01:00:00");
        String title = "Santa Claus course";
        int class_room_id = 2;
        int teacher_id = 3;

        Class_roomDAO crDao;
        Class_room cr = null;

        try {
            crDao = new Class_roomDAO();
            cr = crDao.getById(class_room_id);

        } catch (SQLException ex) {

            fail("SQLException : " + ex.getMessage());

        } catch (DAOException ex) {

            fail("no class room in the db matches with that id ");
        }

        try {
            int idInserted = instance.add(start, end, title, class_room_id, teacher_id);

            instance.remove(start, cr);

        } catch (SQLException ex) {

            fail("SQLException : " + ex.getMessage());
        }

        try {
            instance.remove(start, cr);

            fail("should already have been removed");

        } catch (SQLException ex) {
        }
    }

    /**
     * Test of remove method, of class LessonDAO.
     */
    @Test
    public void testRemove_Timestamp_Staff() {
        System.out.println("remove");

        Timestamp start = Timestamp.valueOf("2016-12-25 00:00:00");
        Timestamp end = Timestamp.valueOf("2016-12-25 01:00:00");
        String title = "Santa Claus course";
        int class_room_id = 2;
        int teacher_id = 3;

        StaffDAO stDao;
        Staff st = null;

        try {
            stDao = new StaffDAO();
            st = stDao.getById(teacher_id);

        } catch (SQLException ex) {

            fail("SQLException : " + ex.getMessage());

        } catch (DAOException ex) {

            fail("no staff member in the db matches with that id ");
        }

        try {
            int idInserted = instance.add(start, end, title, class_room_id, teacher_id);

            instance.remove(start, st);

        } catch (SQLException ex) {

            fail("SQLException : " + ex.getMessage());
        }

        try {
            instance.remove(start, st);

            fail("should already have been removed");

        } catch (SQLException ex) {
        }
    }

    /**
     * Test of edit method, of class LessonDAO.
     */
    @Test
    public void testEdit() {
        System.out.println("edit");
        Lesson lesson = null;
        LessonDAO instance = new LessonDAO();
        instance.edit(lesson);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetById() {
        System.out.println("getById");
        int lesson_id = 3;

        Lesson result = instance.getById(lesson_id);

        assertEquals(3, result.getId());
        assertEquals(Timestamp.valueOf("2016-10-17 15:45:00.000"), result.getTimeStart());
        assertEquals(Timestamp.valueOf("2016-10-17 18:00:00.000"), result.getTimeEnd());
        assertEquals("Biologie cellulaire", result.getTitle());
        assertEquals(1, result.getClass_room_id());
        assertEquals(5, result.getTeacher_id());
    }

    /**
     * Test of getSchedule method, of class LessonDAO.
     */
    @Test
    public void testGetSchedule_3args_1() {
        System.out.println("getSchedule");
        Timestamp time_start = null;
        Timestamp time_end = null;
        Staff teacher = null;
        LessonDAO instance = new LessonDAO();
        ArrayList<Lesson> expResult = null;
        ArrayList<Lesson> result = instance.getSchedule(time_start, time_end, teacher);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSchedule method, of class LessonDAO.
     */
    @Test
    public void testGetSchedule_3args_2() {
        System.out.println("getSchedule");
        Timestamp time_start = null;
        Timestamp time_end = null;
        Degree degree = null;
        LessonDAO instance = new LessonDAO();
        ArrayList<Lesson> expResult = null;
        ArrayList<Lesson> result = instance.getSchedule(time_start, time_end, degree);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSchedule method, of class LessonDAO.
     */
    @Test
    public void testGetSchedule_3args_3() {
        System.out.println("getSchedule");
        Timestamp time_start = null;
        Timestamp time_end = null;
        Class_room class_room = null;
        LessonDAO instance = new LessonDAO();
        ArrayList<Lesson> expResult = null;
        ArrayList<Lesson> result = instance.getSchedule(time_start, time_end, class_room);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
