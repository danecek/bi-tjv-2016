package customers.model;

import java.util.ArrayList;
import java.util.List;
import java.util.NavigableMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentSkipListMap;
import javax.annotation.PostConstruct;
import javax.inject.Singleton;

@Singleton
public class CustomerService {

    public List<Customer> getCustomers() {
        return new ArrayList(customers.values());
    }

    private final NavigableMap<Integer, Customer> customers
            = new ConcurrentSkipListMap<>();

    @PostConstruct
    void init() {
        put("Tom");
        put("Bob");
    }

    public void put(Customer emp) {
        customers.put(emp.getId(), emp);
    }

    public void put(String name) {
        int id = 1;
        if (!customers.isEmpty()) {
            id = customers.lastEntry().getKey() + 1;
        }
        put(new Customer(id, name));
    }

}
