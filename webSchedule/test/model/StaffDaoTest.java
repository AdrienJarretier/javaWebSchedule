package model;

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
     * Test of verify_login method, of class StaffDao.
     */
    @Test
    public void testVerify_login() {
        System.out.println("verify_login");
        String login = "hoche.genevieve@univ.fr";
        String password = "psswdGen";

        StaffDao instance;
        try {
            instance = new StaffDao();

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
     * Test of addStaff method, of class StaffDao.
     */
    @Test
    public void testAddAndRemoveStaff() {
        System.out.println("addAndRemoveStaff");

        String email = "email@testAddStaff.test";
        String first_name = "testAdd";
        String last_name = "Staff";
        String password = "5SVnrp";
        boolean is_admin = false;

        StaffDao instance;
        try {
            instance = new StaffDao();

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

}
