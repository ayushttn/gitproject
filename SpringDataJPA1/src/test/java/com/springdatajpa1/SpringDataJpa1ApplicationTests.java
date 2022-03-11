package com.springdatajpa1;

import com.springdatajpa1.entities.Employee;
import com.springdatajpa1.repos.EmployeeRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class SpringDataJpa1ApplicationTests {

    @Autowired
    EmployeeRepo employeeRepo;

    @Test
    public void testCreate(){
        Employee employee = new Employee();
        employee.setName("Ayush");
        employee.setAge(30);
        employee.setLocation("Delhi");
        employeeRepo.save(employee);
    }

    @Test
    public void testUpdate(){
        Employee employee = employeeRepo.findById(1).get();
        employee.setName("Ayush Tyagi");
        employeeRepo.save(employee);
    }

    @Test
    public void testDelete(){
        if(employeeRepo.existsById(1)){
            System.out.println("Deleting");
            employeeRepo.deleteById(1);
        }
    }

    @Test
    public void testRead(){
        Employee employee = employeeRepo.findById(1).get();
        assertNotNull(employee);
        assertEquals("Ayush", employee.getName());
    }

    @Test
    public void testCount(){
        System.out.println("Total Records" + employeeRepo.count());
    }

    @Test
    public void testPagingAndSortingByAge(){
        Pageable pageable = PageRequest.of(1,1, Sort.by("age"));
        employeeRepo.findAll(pageable).forEach(p -> System.out.println(p.getName()));
    }

    @Test
    public void testFindByName(){
        List<Employee> employees = employeeRepo.findByName("Ayush");
        employees.forEach(p -> System.out.println(p.getId()));
    }

    @Test
    public void testFindByCharA(){
        List<Employee> employees = employeeRepo.findByNameLike("%A%");
        employees.forEach(p -> System.out.println(p.getName()));
    }

    @Test
    public void testFindByAgeBetween(){
        List<Employee> employees = employeeRepo.findByAgeBetween(28,32);
        employees.forEach(p -> System.out.println(p.getName()));
    }
}
