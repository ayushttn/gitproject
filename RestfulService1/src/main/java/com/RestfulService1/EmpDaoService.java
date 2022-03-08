package com.RestfulService1;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmpDaoService {
    private static List<Employee> employees = new ArrayList<>();
    private static int count = 4;

    static {
        employees.add(new Employee(1, "Ayush", 23));
        employees.add(new Employee(2, "Piyush", 30));
        employees.add(new Employee(3, "Shaam", 40));
        employees.add(new Employee(4, "Ram", 20));
    }

    public List<Employee> showAll(){
        return employees;
    }

    public Employee save(Employee employee){
        if(employee.getId() == null){
            employee.setId(++count);
        }
        employees.add(employee);
        return employee;
    }

    public Employee showOne(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    public void updateData(Employee e, int id){
        employees = employees.stream().map(v -> {
            if(v.getId() == id){
                v.setName(e.getName());
                v.setAge(e.getAge());
            }
            return v;
        }).collect(Collectors.toList());
    }

    public Employee deleteById(int id) {
        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            if (employee.getId() == id) {
                iterator.remove();
                return employee;
            }
        }
        return null;
    }
}