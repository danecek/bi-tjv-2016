/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customers;

import customers.integration.CustomerDAO;
import customers.integration.CustomerException;
import customers.integration.DAOFactory;
import customers.integration.DerbyDAOFactory;
import customers.model.Customer;

/**
 *
 * @author danecek
 */
public class Customers {


    public static void main(String[] args) throws CustomerException {
        DAOFactory factory = new DerbyDAOFactory(); // TODO code application logic here
        CustomerDAO customerDAO = factory.getCustomerDAO();
        customerDAO.create(new Customer("Tom"));
        System.out.println(customerDAO.all());
    }
    
}
