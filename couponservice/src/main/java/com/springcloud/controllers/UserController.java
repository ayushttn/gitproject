package com.springcloud.controllers;

import com.springcloud.model.User;
import com.springcloud.repos.UserRepo;
import com.springcloud.security.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/showReg")
    public String showRegistrationPage(){
        return "registerUser";
    }

    @PostMapping("/registerUser")
    public String register(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepo.save(user);
        return "login";
    }

    @GetMapping("/")
    public String showLoginPage(){
        return "login";
    }

    @PostMapping("/login")
    public String login(String email, String password){
        boolean logininfo = securityService.login(email, password);
        if(logininfo){
            return "index";
        }
        return "login";
    }
}
