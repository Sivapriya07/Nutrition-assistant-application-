package com.exercise.process.Repository;

import com.exercise.process.Entity.Role;
import com.exercise.process.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByEmail(String mail);

    User findByName(String name);

    User findOneByEmailAndPassword(String email, String password);

}
