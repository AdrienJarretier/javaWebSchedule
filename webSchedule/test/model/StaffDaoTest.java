package model;

import model.entities.Staff;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
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
     * Test of verify_login method, of class StaffDAO.
     */
    @Test
    public void testVerify_login() {
        System.out.println("verify_login");
        String login = "hoche.genevieve@univ.fr";
        String password = "psswdGen";

        StaffDAO instance;
        try {
            instance = new StaffDAO();

            try {
                instance.verify_login(login, password);
            } catch (NoSuchAlgorithmException ex) {
                fail("hash algo error : " + ex.getMessage());
            } catch (SQLException ex) {
                fail("SQLException : " + ex.getMessage());
            } catch (Exception ex) {
                fail("found incorrect credentials : " + ex.getMessage());
            }

            login = "hoche.genevieve@univ.fr";
            password = "Gen";

            try {
                instance.verify_login(login, password);
                fail("should have found incorrect password");
            } catch (NoSuchAlgorithmException ex) {
                fail("hash algo error : " + ex.getMessage());
            } catch (SQLException ex) {
                fail("SQLException : " + ex.getMessage());
            } catch (Exception ex) {
            }

            login = "hoch.genvieve@univ.fr";
            password = "psswdGen";

            try {
                instance.verify_login(login, password);
                fail("should have found incorrect email");
            } catch (NoSuchAlgorithmException ex) {
                fail("hash algo error : " + ex.getMessage());
            } catch (SQLException ex) {
                fail("SQLException : " + ex.getMessage());
            } catch (Exception ex) {
            }
        } catch (SQLException ex) {
            fail("constructor error : " + ex.getMessage());
        }
    }

    /**
     * Test of addStaff method, of class StaffDAO.
     */
    @Test
    public void testAddAndRemoveStaff() {
        System.out.println("addAndRemoveStaff");

        String email = "email@testAddStaff.test";
        String first_name = "testAdd";
        String last_name = "Staff";
        String password = "5SVnrp";
        boolean is_admin = false;

        StaffDAO instance;
        try {
            instance = new StaffDAO();

            try {
                int idInserted = instance.addStaff(email, first_name, last_name, password, is_admin);

                System.out.println("idInserted : " + idInserted);

                instance.removeStaff(idInserted);

            } catch (NoSuchAlgorithmException ex) {
                fail("hash algo error : " + ex.getMessage());
            } catch (SQLException ex) {
                fail("SQLException : " + ex.getMessage());
            }

        } catch (SQLException ex) {
            fail("constructor error : " + ex.getMessage());
        }
    }

    /**
     * Test of getById method, of class StaffDAO.
     */
    @Test
    public void testGetById() throws Exception {
        System.out.println("getById");
        int staff_id = 3;

        StaffDAO instance;
        try {
            instance = new StaffDAO();

            Staff result = instance.getById(staff_id);

            assertEquals(3, result.getId());
            assertEquals("bernard.claude@univ.fr", result.getEmail());
            assertEquals("Claude", result.getFirstName());
            assertEquals("Bernard", result.getLastName());
            assertEquals(false, result.getIsAdmin());

        } catch (SQLException ex) {
            fail("constructor error : " + ex.getMessage());
        }
    }

}
