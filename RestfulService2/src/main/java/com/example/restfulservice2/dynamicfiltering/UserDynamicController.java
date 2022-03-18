package com.example.restfulservice2.dynamicfiltering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserDynamicController {
    @Autowired
    private UserDynamicService userService;


    @GetMapping("/users/dynamic/{id}")
    public MappingJacksonValue getUserFilteringPasswordDynamic(@PathVariable int id){
        UserDynamic userDynamic = userService.findOne(id);
        UserDynamic us = new UserDynamic(userDynamic.getId() , userDynamic.getName() , userDynamic.getEmail() , userDynamic.getPassword());
        SimpleBeanPropertyFilter simpleBeanPropertyFilter = SimpleBeanPropertyFilter.filterOutAllExcept("id","name","email");
        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("password" , simpleBeanPropertyFilter);
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(us);
        mappingJacksonValue.setFilters(filterProvider);
        return mappingJacksonValue;


    }


    @GetMapping("/get/userdynamic")
    public List<UserDynamic> getAllUsers(){
        return userService.findAll();
    }


    @PostMapping("/save/userdynamic")
    public void addUser(@RequestBody UserDynamic user){
        UserDynamic user1 = userService.saveContacts(user);
    }
}