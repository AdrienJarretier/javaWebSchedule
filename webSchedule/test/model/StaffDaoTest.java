package model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author freeze
 */
public class StaffDaoTest {
    
    public StaffDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of verify_login method, of class StaffDao.
     */
    @Test
    public void testVerify_login() throws Exception {
        System.out.println("verify_login");
        String login = "";
        String password = "";
        StaffDao instance = new StaffDao();
        Staff expResult = null;
        Staff result = instance.verify_login(login, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addStaff method, of class StaffDao.
     */
    @Test
    public void testAddStaff() throws Exception {
        System.out.println("addStaff");
        String email = "";
        String first_name = "";
        String last_name = "";
        String password = "";
        boolean is_admin = false;
        StaffDao instance = new StaffDao();
        int expResult = 0;
        int result = instance.addStaff(email, first_name, last_name, password, is_admin);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
