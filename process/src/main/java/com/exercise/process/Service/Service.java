package com.exercise.process.Service;

import com.exercise.process.Repository.UserRepository;
import com.exercise.process.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service

public class Service {
    @Autowired
    private UserRepository userRepository;

    public User saveUser(User u){
        return userRepository.save(u);
    }


    public List<User> getDetails(){
        return userRepository.findAll();
   }


   public Optional<User> getUserbyId(int id){

        return userRepository.findById(id);
   }

}
