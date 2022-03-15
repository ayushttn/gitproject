package com.springdatajpa2;

import com.springdatajpa2.entities.*;
import com.springdatajpa2.repos.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;
import java.util.List;

@SpringBootTest
class SpringDataJpa2ApplicationTests {

    @Autowired
    EmployeeRepository employeeRepository;

    @Test
    public void create(){
        Employee employee = new Employee();
        employee.setFirstName("Ayush");
        employee.setLastName("Singh");
        employee.setSalary(20000d);
        employee.setAge(60);
        employeeRepository.save(employee);
        Employee employee2 = new Employee();
        employee2.setFirstName("Piyush");
        employee2.setLastName("Tyagi");
        employee2.setSalary(30000d);
        employee2.setAge(70);
        employeeRepository.save(employee2);
        Employee employee3 = new Employee();
        employee3.setFirstName("Ram");
        employee3.setLastName("Sharma");
        employee3.setSalary(40000d);
        employee3.setAge(60);
        employeeRepository.save(employee3);
        Employee employee4 = new Employee();
        employee4.setFirstName("Shaam");
        employee4.setLastName("Verma");
        employee4.setSalary(25000d);
        employee4.setAge(46);
        employeeRepository.save(employee4);

    }

    @Test
    public void findAllBySortOfAgeAndSalary(){
        List<Object[]> result = employeeRepository.findAndSortBySalaryAndAge(Sort.by(Sort.Order.by("age"), new Sort.Order(Direction.DESC, "salary")));
        for (Object[] objects: result){
            System.out.println(objects[0] + " " + objects[1] + " " + objects[2]);
        }
    }

    @Test
    @Transactional
    @Rollback(value = false)
    public void updateSalary(){
        employeeRepository.updateSalary(300d, employeeRepository.avgSalary());
    }

    @Test
    @Transactional
    @Rollback(value = false)
    public void deleteEmployeeWithMinSalary(){
        employeeRepository.deleteEmployeeWithMinSalary(employeeRepository.minSalary());
    }

    @Test
    public void getByLastName(){
        List<Object[]> result = employeeRepository.getEmployeeWithLastNameAs();
        for (Object[] obj: result){
            System.out.println(obj[0] + " " + obj[1] + " " + obj[2]);
        }
    }


    @Test
    @Transactional
    @Rollback(value = false)
    public void deleteEmpAboveAge(){
        employeeRepository.deleteEmployeeAboveAge();
    }

    //Inheritance Mapping
    //SingleTable Inheritance

    @Autowired
    WorkerRepository workerRepository;

    @Test
    public void createActiveWorker(){
        ActiveWorkers aw = new ActiveWorkers();
        aw.setId(1);
        aw.setName("Ayush");
        aw.setSalary(20000d);
        workerRepository.save(aw);
    }

    @Test
    public void createRetiredWorker(){
        RetiredWorkers rw = new RetiredWorkers();
        rw.setId(2);
        rw.setName("Piyush");
        rw.setPension(10000d);
        workerRepository.save(rw);
    }

    //TablePerClass

    @Autowired
    OrderRepository orderRepository;

    @Test
    public void createOnlineOrder(){
        OnlineOrder order = new OnlineOrder();
        order.setId(1);
        order.setName("Tv");
        order.setOnlineOrderId(2342);
        orderRepository.save(order);
    }

    @Test
    public void createCashOnDelOrder(){
        CodOrders order = new CodOrders();
        order.setId(1);
        order.setName("Tv");
        order.setCodOrderId(2342);
        orderRepository.save(order);
    }

    //Joined
    @Autowired
    PaymentRepository paymentRepository;

    @Test
    public void createPayment() {
        CreditCard cc = new CreditCard();
        cc.setId(123);
        cc.setAmount(1000);
        cc.setCardnumber("1234567890");
        paymentRepository.save(cc);
    }

    @Test
    public void createCheckPayment() {
        Check ch = new Check();
        ch.setId(124);
        ch.setAmount(1000);
        ch.setChecknumber("1234567890");
        paymentRepository.save(ch);
    }

    //ComponentMapping

    @Autowired
    EmployeeComponentRepository employeeComponentRepository;
    @Test
    public void createEmp(){
        EmployeeComponent emp = new EmployeeComponent();
        emp.setId(1);
        emp.setFirstName("Ayush");
        emp.setLastName("Tyagi");
        emp.setAge(23);
        Salary salary = new Salary();
        salary.setBasicSalary(10000d);
        salary.setBonusSalary(10000d);
        salary.setTaxAmount(20000d);
        salary.setSpecialAllowanceSalary(20000d);
        emp.setSalary(salary);
        employeeComponentRepository.save(emp);
    }

}
