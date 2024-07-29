package com.exercise.process.Controller;

import com.exercise.process.Service.Service;
import com.exercise.process.Entity.User;
import com.exercise.process.dto.loginDTO;
import com.exercise.process.jwtAuth.JwtUtil;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;

@ComponentScan
@RestController
@RequestMapping("/api")
@Validated
public class UserController {

    @Autowired
    private Service userService;
    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    AuthenticationManager authenticationManager;

    @PostMapping("/save")
//    @PreAuthorize("hasRole('admin','user')")
    public ResponseEntity<HashMap<String, String>> createUser(@RequestBody @Valid User userInput) {
        HashMap<String, String> createdUser = userService.saveUser(userInput);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @GetMapping("/login")
    public ResponseEntity<HashMap<String,String>> login(@RequestBody loginDTO logindto) {
        System.out.println("working");
        System.out.println(logindto.getEmail());

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(logindto.getEmail(), logindto.getPassword()));

         //   UserDetails userDetails = userService.loadUserByUsername(logindto.getEmail());
            String jwt = jwtUtil.generateToken(logindto).get("token");
            HashMap<String,String> response = new HashMap<>();
            response.put("token",jwt);
            System.out.println(jwt);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            HashMap<String, String> l = new HashMap<>();
            l.put("error",e.toString());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(l);
        }
        //return new ResponseEntity<>(jwtUtil.generateToken(logindto), HttpStatus.OK);

    }

    @GetMapping("/select")
    @PreAuthorize("hasRole('ADMIN')")
    public List<User> getAllUsers() {

        return userService.getDetails();
    }

    @GetMapping("/{id}")
    //@PreAuthorize("hasRole('admin')")
    public ResponseEntity<User> getUserById(@PathVariable int id) {
        return userService.getUserbyId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/verify")
    public ResponseEntity<HashMap<String,Object>> verifyJwt(User user) {
        HashMap<String,Object> responseMap = new HashMap<>();

        String authorisation="eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJoYXJpIiwiaWF0IjoxNzIxOTc2MjM1LCJleHAiOjE3MjIwMTIyMzV9.EICit4W3bVNSuAgvIyG3kD_H9BNWzBZNhNgPpCl8H5hyOixKF0UpXxVf0uakQIIFnMrL1KE88KmmqjNZQ-WHeg";
        try {
            jwtUtil.extractAllClaims(authorisation);
            responseMap.put("data", "The token is verified and validated");
            responseMap.put("status", HttpStatus.OK);
            return ResponseEntity.status(HttpStatus.OK).body(responseMap);
        } catch (Exception e) {
            responseMap.put("data", "Invalid token");
            responseMap.put("status", HttpStatus.UNAUTHORIZED);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseMap);
        }
    }

//    @GetMapping("/{field}")
//    private ResponseEntity<List<User>> getnamewithsorting(@PathVariable String field){
//        List<User> allusers = userService.usingSorting(field);
//        return new ResponseEntity<>(allusers, HttpStatus.OK);
//
//    }

    //pagination
    @GetMapping("/pagination/{offset}/{pagesize}")
    //@PreAuthorize("hasRole('admin')")
    public ResponseEntity<Page<User>> getUsersWithPagination(@PathVariable int offset, @PathVariable int pagesize) {
        Page<User> allUsers = userService.usageOfPagination(offset, pagesize);
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }


}