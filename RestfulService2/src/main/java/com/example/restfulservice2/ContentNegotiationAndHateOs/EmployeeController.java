package com.example.restfulservice2.ContentNegotiationAndHateOs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService service;

    @GetMapping("/get/employees")
    public List<Employee> getAllUsers(){
        return service.findAll();
    }

    @GetMapping("/get/employee/{id}")
    public EntityModel<Employee> getById(@PathVariable int id){
        Employee employee = service.findById(id);

        EntityModel<Employee> entityModel = EntityModel.of(employee);
        WebMvcLinkBuilder linkBuilder = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllUsers());
        entityModel.add(linkBuilder.withRel("employees"));
        return entityModel;
    }

    @PostMapping("/save/employee")
    public void addUser(@RequestBody Employee emp){
        Employee employee = service.saveEmployee(emp);
    }
}
