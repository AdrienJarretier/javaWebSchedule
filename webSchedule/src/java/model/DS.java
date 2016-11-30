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
 * @author Laurie
 */
public class DS {
    
    private DS(){
        
    }
    
    /**
     * 
     * @return
     * @throws SQLException 
     */
    public static DataSource getDataSource() throws SQLException {
        org.apache.derby.jdbc.ClientDataSource ds = new org.apache.derby.jdbc.ClientDataSource();
        ds.setDatabaseName("schedule");
        ds.setUser("sched");
        ds.setPassword("sched");
        // The host on which Network Server is running
        ds.setServerName("localhost");
        // port on which Network Server is listening
        ds.setPortNumber(1527);
        return ds;
    }
}
