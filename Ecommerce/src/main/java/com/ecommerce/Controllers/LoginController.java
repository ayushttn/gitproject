package com.ecommerce.Controllers;

import com.ecommerce.Handler.ResponseHandler;
import com.ecommerce.Security.SecurityServiceImpl;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.endpoint.TokenEndpoint;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Map;

@RestController
public class LoginController {

    @Autowired
    private SecurityServiceImpl securityService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private TokenEndpoint tokenEndpoint;

//    @PostMapping("/login")
//    public ResponseEntity<Object> login(@RequestBody ObjectNode objectNode) {
//        String email = objectNode.get("email").asText();
//        String password = objectNode.get("password").asText();
//        boolean loginResponse = securityService.login(email, password);
//        if (loginResponse) {
//            return ResponseHandler.generateResponse("Login Successful", HttpStatus.OK);
//        }
//        return ResponseHandler.generateResponse("Username and Password do not exist", HttpStatus.BAD_REQUEST);
//    }
}
