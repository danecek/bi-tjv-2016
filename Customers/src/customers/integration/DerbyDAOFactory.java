/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customers.integration;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.derby.jdbc.EmbeddedDriver;

/**
 *
 * @author danecek
 */
public class DerbyDAOFactory implements DAOFactory {

    DerbyCustomerDAO derbyCustomerDAO;
    private Connection conn = null;
    String url = "";

    public DerbyDAOFactory() {
        try {
            new EmbeddedDriver();
            String url = "jdbc:derby:" + System.getProperty("user.home") + "/customersDB; create=true";
            conn = DriverManager.getConnection(url);
            DatabaseMetaData dbmd = conn.getMetaData();
            ResultSet rs = dbmd.getTables(null, null, "CUSTOMERS", null);
            if (!rs.next()) {
                LOG.info("CREATE TABLE CUSTOMERS");
                Statement stm = conn.createStatement();
                stm.executeUpdate("CREATE TABLE CUSTOMERS"
                        + "(ID INT NOT NULL GENERATED ALWAYS AS IDENTITY,"
                        + "NAME   VARCHAR(50),"
                        + "PRIMARY KEY (ID))");
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAODerbyFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private static final Logger LOG = Logger.getLogger(DerbyDAOFactory.class.getName());

    @Override
    public CustomerDAO getCustomerDAO() {

        if (derbyCustomerDAO == null) {
            try {
                derbyCustomerDAO = new DerbyCustomerDAO(conn);
            } catch (SQLException ex) {
                Logger.getLogger(DerbyDAOFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return derbyCustomerDAO;

    }

}
