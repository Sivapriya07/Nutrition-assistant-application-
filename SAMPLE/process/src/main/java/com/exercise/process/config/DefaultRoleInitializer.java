package com.exercise.process.config;

import com.exercise.process.Entity.Role;
import com.exercise.process.Entity.User;
import com.exercise.process.Repository.Rolerepository;
import com.exercise.process.Repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import jakarta.annotation.PostConstruct;

@Configuration
public class DefaultRoleInitializer {
    private final Rolerepository rolerepo;
    private final UserRepository userrepo;

    public DefaultRoleInitializer(Rolerepository rolerepo, UserRepository userrepo) {
        this.rolerepo = rolerepo;
        this.userrepo = userrepo;
    }

    @PostConstruct
    public void init(){
        if(rolerepo.count() == 0){
          Role userRole = new Role();
            userRole.setRolename("user");
            rolerepo.save(userRole);

            Role adminRole = new Role();
            adminRole.setRolename("admin");
            rolerepo.save(adminRole);

            Role superAdminRole = new Role();
            superAdminRole.setRolename("superAdmin");
            rolerepo.save(superAdminRole);
        }


        if (userrepo.count()==0) {
            //Role superAdminRole = rolerepo.findById(3).orElseThrow(() -> new RuntimeException("Superadmin role does not exist"));


            Role role;

            User superadmin = new User();
            superadmin.setName("SuperAdmin");
            superadmin.setEmail("superadmin@gmail.com");
            superadmin.setPhone_no("9345623987");
            superadmin.setPassword("12345@shr");
            superadmin.setStatus("active");
            superadmin.setRole(rolerepo.findByRolename("superAdmin"));

            userrepo.save(superadmin);
        }

        System.out.println("Default roles and superadmin are set successfully");
    }

    }

