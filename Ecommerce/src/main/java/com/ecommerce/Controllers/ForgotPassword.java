package com.ecommerce.Controllers;

import com.ecommerce.Entities.ConfirmationToken;
import com.ecommerce.Entities.User;
import com.ecommerce.Handler.ResponseHandler;
import com.ecommerce.Repos.TokenRepository;
import com.ecommerce.Repos.UserRepository;
import com.ecommerce.Service.UserService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


@RestController
public class ForgotPassword {

    @Autowired
    private UserService userService;

    @Autowired
    private TokenRepository tokenRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @PostMapping(value = {"/forgot-password"})
    public ResponseEntity<Object> forgotPassword(@RequestBody ObjectNode objectNode) {
        String email = objectNode.get("email").asText();
        User user=userService.forgotPassword(email);
        if (user == null) {
            return ResponseHandler.generateResponse("User Not Found", HttpStatus.NOT_FOUND);
        }
        return ResponseHandler.generateResponse("User Found", HttpStatus.OK);
    }

    @PutMapping(value = {"/reset-password"})
    public ResponseEntity<Object> resetPassword(@RequestParam("token") String confirmationToken, @RequestBody ObjectNode objectNode) {
        ConfirmationToken token = tokenRepository.findByConfirmationToken(confirmationToken);
        if (token != null) {
            User user = userRepository.findByEmail(token.getUserEntity().getEmail());
            String newPassword = objectNode.get("newPassword").asText();
            String confirmPassword = objectNode.get("confirmPassword").asText();
            if(newPassword.equals(confirmPassword)){
                user.setPassword(passwordEncoder.encode(newPassword));
                userRepository.save(user);
                tokenRepository.delete(token);
                return ResponseHandler.generateResponse("Password Changed Successfully!", HttpStatus.OK);
            }
            else {
                return ResponseHandler.generateResponse("New Password and Confirm Password Do not Match!", HttpStatus.BAD_REQUEST);
            }
        } else {
            return ResponseHandler.generateResponse("Invalid Token", HttpStatus.NOT_FOUND);
        }
    }
}
