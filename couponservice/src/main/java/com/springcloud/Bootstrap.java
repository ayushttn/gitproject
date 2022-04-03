package com.springcloud;

import com.springcloud.model.Role;
import com.springcloud.model.User;
import com.springcloud.repos.RoleRepo;
import com.springcloud.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Component
public class Bootstrap implements ApplicationRunner {

    @Autowired
    UserRepo userRepo;

    @Autowired
    RoleRepo roleRepo;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if(Objects.isNull(userRepo.findByEmail("piyush@gmail.com"))) {
            Role role = new Role();
            role.setName("ROLE_ADMIN");
            Role savedRole = roleRepo.save(role);

            Set<Role> roles = new HashSet<>();
            roles.add(savedRole);

            User user = new User();
            user.setFirstName("Piyush");
            user.setLastName("Tyagi");
            user.setEmail("piyush@gmail.com");
            user.setPassword(passwordEncoder.encode("piyush"));
            //SET FIRSTNAME AND LASTNAME USING SETTER
            user.setRoles(roles);
            userRepo.save(user);
        }
        if(Objects.isNull(userRepo.findByEmail("ayush@gmail.com"))) {
            Role role = new Role();
            role.setName("ROLE_USER");
            Role savedRole = roleRepo.save(role);

            Set<Role> roles = new HashSet<>();
            roles.add(savedRole);


            User user = new User();
            user.setFirstName("Ayush");
            user.setLastName("Tyagi");
            user.setEmail("ayush@gmail.com");
            user.setPassword(passwordEncoder.encode("ayush"));


            //SET FIRSTNAME AND LASTNAME USING SETTER
            user.setRoles(roles);
            userRepo.save(user);
        }
    }
}