package com.springdatajpa2.repos;

import com.springdatajpa2.entities.Employee;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

    //JPQL Queries
    //1. Display the first name, last name of all employees having salary greater than average salary ordered in ascending by their age and in descending by their salary.
    @Query("select e.firstName, e.lastName, e.salary from Employee e where e.salary>(select AVG(salary) from Employee)")
    List<Object[]> findAndSortBySalaryAndAge(Sort sort);

    //2. Update salary of all employees by a salary passed as a parameter whose existing salary is less than the average salary.
    @Query("select avg(salary) from Employee")
    double avgSalary();

    @Modifying
    @Query("update Employee set salary =:salary where salary<:avgSalary")
    void updateSalary(@Param("salary") double salary, @Param("avgSalary") double avgSalary);

    //3. Delete all employees with minimum salary.
    @Query("select min(salary) from Employee")
    double minSalary();

    @Modifying
    @Query("delete from Employee where salary=:minSalary")
    void deleteEmployeeWithMinSalary(@Param("minSalary") double minSalary);

    //Native SQL Query:
    //1. Display the id, first name, age of all employees where last name ends with "singh"
    @Query(value = "select e.empid, e.empFirstName, e.empAge from employeeTable e where e.empLastName LIKE 'Singh'", nativeQuery = true)
    List<Object[]> getEmployeeWithLastNameAs();

    //2. Delete all employees with age greater than 45(Should be passed as a parameter)
    @Modifying
    @Query(value = "delete from employeeTable where empAge > 45",nativeQuery = true)
    void deleteEmployeeAboveAge();
}
