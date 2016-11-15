/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpatest2;

import java.util.Date;

public class JPATest2 {


    public static void main(String[] args) throws Exception {
        CustomerDAO cdao = new CustomerDAO();
        cdao.create(new Customer("Tom"));
        System.out.println(cdao.all());
        cdao.addOrder(51L, new Order(new Date().toString()));
        Customer c = cdao.find(51L);
        System.out.println(c);
    }

}
