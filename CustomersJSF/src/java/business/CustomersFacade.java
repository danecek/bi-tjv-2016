/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import integration.CustomersDAO;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import model.Customer;

@Stateless
@Path("customers")
public class CustomersFacade {

    @Inject
    CustomersDAO customerDAO;

    @GET
    public List<Customer> getCustomers() {
        return customerDAO.getCustomers();
    }

    public void add(Customer c) {
        customerDAO.add(c);
    }

    public void delete(Long id) {
        customerDAO.delete(id);
    }

    public Customer find(Long id) {
        return customerDAO.find(id);
    }
}
