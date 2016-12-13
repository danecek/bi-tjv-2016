/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backing;

import business.CustomersFacade;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import model.Customer;

@Named("indexb") @RequestScoped
public class Index {

    @Inject
    CustomersFacade customersData;

    public List<Customer> getCustomers() {
        return customersData.getCustomers();
    }

}
