package com.exercise.process;

import com.exercise.process.Repository.UserRepository;
import com.exercise.process.model.User;
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

    public User getUserbyId(int id){
        return userRepository.findById(id).orElse(null);
    }


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User deletebyId(int id){
        userRepository.deleteById(id);

        return null;
    }
//    public List<User> getDetails(){
//        return userRepository.findAll();
//    }
}
