/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Singleton;
import model.Customer;

@Singleton
public class CustomersData {

    private static final Logger LOG = Logger.getLogger(CustomersData.class.getName());
    
    

    private Map<String, Customer> customers;

    @PostConstruct
    public void init() {
        customers = new HashMap<>();
        add(new Customer("Tom"));
        add(new Customer("Bob"));
    }

    public List<Customer> getCustomers() {
        return new ArrayList<>(customers.values());
    }

    public void add(Customer c) {
        customers.put(c.getName(), c);
    }

    public void delete(String name) {
        LOG.info(name);
        customers.remove(name);
    }
}
