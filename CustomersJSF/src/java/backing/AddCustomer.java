/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backing;

import business.CustomersFacade;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import model.Customer;

@Model
public class AddCustomer {

    private String name;

    @Inject
    CustomersFacade customersData;

    public String add() {
        Customer c = new Customer(name);
        customersData.add(c);
        return "index?faces-redirect=true";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
