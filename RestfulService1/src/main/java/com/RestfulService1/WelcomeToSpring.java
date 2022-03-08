package com.RestfulService1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeToSpring {
    @GetMapping(path =  "/wts")
    public String WTS(){
        return "Welcome to Spring";
    }
}
