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
public class OrderDAO {

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPATest2PU");

    public void create(Order c) throws Exception {
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

    public List<Order> all() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        try {
            TypedQuery<Order> tq = em.createQuery("SELECT c FROM Order c", Order.class);
            et.commit();
            return tq.getResultList();
        } catch (Exception ex) {
            et.rollback();
            throw ex;
        }
    }

}
