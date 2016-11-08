/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customers.integration;

import customers.model.Customer;
import java.util.List;

public interface CustomerDAO {

    List<Customer> all() throws CustomerException;

    void create(Customer c) throws CustomerException;

}
