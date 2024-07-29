package com.exercise.process.Repository;

import com.exercise.process.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Rolerepository extends JpaRepository<Role,Integer> {

    Role findByRolename(String rolename);
}
