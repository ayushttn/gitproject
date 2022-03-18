package com.example.restfulservice2.dynamicfiltering;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDynamicService{
    public static List<UserDynamic> users = new ArrayList<>();
    public static int count = 2;
    static {
        users.add(new UserDynamic(1 , "Ayush" , "ayushttn@gmail.com" , "ayush"));
        users.add(new UserDynamic(2 , "Piyush" , "piyush@gmail.com" , "piyush"));

    }

    public List<UserDynamic> findAll() {
        return users;
    }

    public UserDynamic saveContacts(UserDynamic user){
        if(user.getId() == null){
            user.setId(++count);
        }
        users.add(user);
        return user;
    }

    public UserDynamic findOne(int id){
        for(UserDynamic user : users){
            if(user.getId() == id){
                return user;
            }
        }
        return null;
    }
}