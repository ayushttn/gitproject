package com.RestfulService1;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class EmployeeService {

    @Autowired
    private EmpDaoService Service;

    @GetMapping(path = "/employees")
    public List<Employee> RetriveAllEmp(){
        return Service.showAll();
    }

    @GetMapping("/top/{id}")
    public Employee retrieveUser(@PathVariable int id){
        Employee user = Service.showOne(id);
        if(user==null){
            throw new EmpNotFound("id-" + id);
        }
        return user;

    }

    @PostMapping("/employees")
    public ResponseEntity<Object> createUser(@Valid @RequestBody Employee employee){
        Employee savedemployee = Service.save(employee);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedemployee.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/update/{id}")
    public Employee updateEmployee(@RequestBody Employee emp, @PathVariable int id){
        Service.updateData(emp, id);
        return emp;
    }

    @DeleteMapping("/employee/{id}")
    public void deleteUser(@PathVariable int id){
        Employee user = Service.deleteById(id);
        if(user==null){
            throw new EmpNotFound("id-" + id);
        }
    }
}
