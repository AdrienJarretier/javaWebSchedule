/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import model.StaffDAO;

/**
 *
 * @author Jarretier Adrien "jarretier.adrien@gmail.com"
 */
public class Datas2StaffInserts {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, NoSuchAlgorithmException {

        StaffDAO staffDao = new StaffDAO();

        staffDao.addStaff("bertrand.françois@univ.fr", "François", "Bertrand", "psswdFra", false);
        staffDao.addStaff("gallard.julien@univ.fr", "Julien", "Gallard", "psswdJul", false);
        staffDao.addStaff("bernard.claude@univ.fr", "Claude", "Bernard", "psswdCla", false);
        staffDao.addStaff("salma.juliette@univ.fr", "Juliette", "Salma", "psswdJul", false);
        staffDao.addStaff("hoche.genevieve@univ.fr", "Geneviève", "Hoche", "psswdGen", false);
        staffDao.addStaff("pilo.jaques@univ.fr", "Jacques", "Pilo", "psswdJac", true);

    }

}
