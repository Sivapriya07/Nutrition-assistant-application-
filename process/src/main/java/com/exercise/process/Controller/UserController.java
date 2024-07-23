package com.exercise.process.Controller;

import com.exercise.process.Service.Service;
import com.exercise.process.Entity.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
public class UserController {

    @Autowired
    private Service userService;

    @PostMapping("/save")
    public ResponseEntity<User> createUser(@RequestBody @Valid User userInput) {
        return new ResponseEntity<>(userService.saveUser(userInput),HttpStatus.CREATED);
    }

   @GetMapping("/select")
    public List<User> getAllUsers() {

        return userService.getDetails();
   }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id) {
        return userService.getUserbyId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}