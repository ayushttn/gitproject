package com.example.restfulservice2.staticfiltering;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserStaticController{

    @Autowired
    private UserStaticService userService;

    @GetMapping("users/static/{id}")
    public UserStatic getFilteringPasswordstatic(@PathVariable int id){
        UserStatic user = userService.findOne(id);
        return new UserStatic(user.getId() , user.getName() , user.getEmail() , user.getPassword());
    }

    @GetMapping("/get/userstatic")
    public List<UserStatic> getAllContacts(){
        return userService.findAll();
    }

    @PostMapping("/save/userstatic")
    public void addContact(@RequestBody UserStatic user){
        UserStatic user1 = userService.saveContacts(user);
    }
}
