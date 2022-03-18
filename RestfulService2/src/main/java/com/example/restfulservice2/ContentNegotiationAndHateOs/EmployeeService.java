package com.example.restfulservice2.ContentNegotiationAndHateOs;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeService {
    public static List<Employee> employees = new ArrayList<>();
    public static int count = 2;
    static {
        employees.add(new Employee(1,"Ayush"));
        employees.add(new Employee(2,"Piyush"));
    }

    public List<Employee> findAll(){
        return employees;
    }

    public Employee findById(int id){
        for(Employee employee : employees){
            if(employee.getId() == id){
                return employee;
            }
        }
        return null;

    }

    public Employee saveEmployee(Employee employee){
        if(employee.getId() == null){
            employee.setId(++count);
        }
        employees.add(employee);
        return employee;
    }
}
