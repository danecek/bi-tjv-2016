package com.example.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
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
        put(new Employee(1, "Tom"));
        put(new Employee(2, "Bob"));
    }

    public Optional<Employee> findByEmpId(Integer id) {
        return Optional.ofNullable(new Employee(1, "Tom"));//employees.get(id));
    }

    public void put(Employee emp) {
        employees.put(emp.getId(), emp);
    }

    public void put(String name) {
        SortedSet<Integer> keys = (java.util.SortedSet<Integer>) employees.keySet();
        put(new Employee(keys.last() + 1, name));
    }

}
