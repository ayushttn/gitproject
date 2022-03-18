package com.example.restfulservice2.hellousername;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.LocaleContextResolver;

@RestController
public class HelloUsernameController {

    @Autowired
    private MessageSource messageSource;

    @GetMapping(path = "/hello/path-variable/{username}")
    public String helloUserNamePathVar(@PathVariable String username){
        return messageSource.getMessage("Hello.message", null, LocaleContextHolder.getLocale())  + " " + username;
    }

}
