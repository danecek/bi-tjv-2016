/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpatest2;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author danecek
 */
public class CustomerDAO {

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPATest2PU");

    public void addOrder(Long custId, Order o) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        try {
            em.persist(o);
            Customer c = em.find(Customer.class, custId);
            c.getOrders().add(o);
            o.setCustomer(c);
            et.commit();
        } catch (Exception ex) {
            et.rollback();
            throw ex;
        }
    }

    public Customer find(Long custId) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        try {
            Customer c = em.find(Customer.class, custId);
            et.commit();
            return c;
        } catch (Exception ex) {
            et.rollback();
            throw ex;
        }
    }

    public void create(Customer c) throws Exception {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        try {
            em.persist(c);
            et.commit();
        } catch (Exception ex) {
            et.rollback();
            throw ex;
        }
    }

    public List<Customer> all() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        try {
            TypedQuery<Customer> tq = em.createQuery("SELECT c FROM Customer c", Customer.class);
            et.commit();
            return tq.getResultList();
        } catch (Exception ex) {
            et.rollback();
            throw ex;
        }
    }

}
