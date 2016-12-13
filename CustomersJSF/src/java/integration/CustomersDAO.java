/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integration;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.Customer;

@Stateless
public class CustomersDAO {

    @PersistenceContext
    EntityManager em;

    public List<Customer> getCustomers() {
        Query q = em.createNamedQuery("selectall");
        return q.getResultList();
    }

    public void add(Customer c) {
        em.persist(c);
    }

    public void delete(Long id) {
        Customer c = find(id);
        em.remove(c);

    }

    public Customer find(Long id) {
       return em.find(Customer.class, id);
    }

}
