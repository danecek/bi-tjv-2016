package customers.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeMap;
import javax.annotation.PostConstruct;
import javax.inject.Singleton;

@Singleton
public class EmployeeService {

    public List<Employee> getEmployees() {
        return new ArrayList(employees.values());
    }

    private final Map<Integer, Employee> employees = new TreeMap<>();

    @PostConstruct
    void init() {
        put("Tom");
        put("Bob");
    }

    public void put(Employee emp) {
        employees.put(emp.getId(), emp);
    }

    public void put(String name) {
        int id = 1;
        if (!employees.isEmpty()) {
            id = ((SortedSet<Integer>) employees.keySet()).last() + 1;
        }
        put(new Employee(id, name));
    }

}
