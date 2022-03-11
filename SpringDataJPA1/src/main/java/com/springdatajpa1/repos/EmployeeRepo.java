package com.springdatajpa1.repos;

import com.springdatajpa1.entities.Employee;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface EmployeeRepo extends PagingAndSortingRepository<Employee, Integer> {
    List<Employee> findByName(String name);
    List<Employee> findByNameLike(String name);
    List<Employee> findByAgeBetween(int age1, int age2);
}
