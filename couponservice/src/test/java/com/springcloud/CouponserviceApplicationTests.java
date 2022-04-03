package com.springcloud;

import com.springcloud.model.Role;
import com.springcloud.model.User;
import com.springcloud.repos.UserRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;

@SpringBootTest
class CouponserviceApplicationTests {

    @Autowired
    UserRepo userRepo;

    @Test
    public void createUser(){
        User user = new User();
        Role role = new Role();
        user.setFirstName("Ayush");
        user.setLastName("Tyagi");
        user.setEmail("ayushttn@gmail.com");
        role.setName("ROLE_ADMIN");
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        user.setRoles(roles);
        userRepo.save(user);
    }

}
