/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customers.integration;

import customers.model.Customer;
import customers.model.CustomerId;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DerbyCustomerDAO implements CustomerDAO {

    Statement stm;
    PreparedStatement createPs;

    public DerbyCustomerDAO(Connection con) throws SQLException {
        stm = con.createStatement();
        createPs = con.prepareStatement("INSERT INTO CUSTOMERS VALUES(DEFAULT, ?)");
    }

    @Override
    public void create(Customer c) throws CustomerException {
        try {
            createPs.setString(1, c.getName());
            createPs.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DerbyCustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new CustomerException(ex);
        }
    }

    @Override
    public List<Customer> all() throws CustomerException {
        try {
            ResultSet rs = stm.executeQuery("SELECT * FROM CUSTOMERS");
            List<Customer> cl = new ArrayList<>();
            while (rs.next()) {
                cl.add(new Customer(new CustomerId(rs.getInt(1)), rs.getString(2)));
            }
            return cl;
        } catch (SQLException ex) {
            Logger.getLogger(DerbyCustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new CustomerException(ex);
        }

    }

}
