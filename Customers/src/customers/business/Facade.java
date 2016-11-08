
package customers.business;

import customers.model.Order;
import customers.integration.CustomerException;
import customers.integration.DAOFactory;
import customers.model.Customer;
import customers.model.CustomerId;


public class Facade {
    
    DAOFactory fact;
    
    public void createCustomer(Customer c) throws CustomerException {
        fact.getCustomerDAO().create(c);        
    }
    
    public void addOrder(CustomerId cId, Order o) {
        
    }
    
}
