package com.exercise.process.Controller;

import com.exercise.process.Service;
import com.exercise.process.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private Service userService;

    @GetMapping ("/adduser")
    public void createUser(@RequestBody User userInput) {

        userService.saveUser(userInput);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping ("retrieve/{id}")
    public User getUserbyId(@PathVariable int id){
        return userService.getUserbyId(id);
    }

    @DeleteMapping ("delete/{id}")
    public User deletebyId(@PathVariable int id){
        return userService.deletebyId(id);
    }

}
