/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backing;

import data.CustomersData;
import java.util.List;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import model.Customer;

@Model //= @Named @RequestScoped
public class Index {

    @Inject
    CustomersData customersData;

    public List<Customer> getCustomers() {
        return customersData.getCustomers();
    }

}
