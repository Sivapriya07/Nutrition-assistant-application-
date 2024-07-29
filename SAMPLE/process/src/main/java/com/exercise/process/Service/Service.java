package com.exercise.process.Service;

import com.exercise.process.Repository.Rolerepository;
import com.exercise.process.Repository.UserRepository;
import com.exercise.process.Entity.User;
import com.exercise.process.dto.loginDTO;
import com.exercise.process.jwtAuth.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class Service {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private Rolerepository rolerepository;
    @Autowired
    private JwtUtil jwtUtil;


    //SignupAPI
    public HashMap<String,String> saveUser(User userInput) {
    if(userRepository.findByName(userInput.getName())==null){
        userInput.setRole(rolerepository.findByRolename("user"));
        userInput.setStatus("inactive");
        userRepository.save(userInput);
        HashMap<String,String> h=new HashMap<>();
        h.put("message","signup successfully");
        return h;
    }
    HashMap<String,String> hm=new HashMap<>();
    hm.put("message","user already exist");
    return hm;
    }

    public List<User> getDetails(){
        return userRepository.findAll();
   }


   public Optional<User> getUserbyId(int id){
        return userRepository.findById(id);
   }

   //LoginAPI
    public HashMap<String, String> loginUser(loginDTO logindto) {
    //named query --- findOneByEmailAndPassword
    User user = userRepository.findOneByEmailAndPassword(logindto.getEmail(),logindto.getPassword());
    HashMap<String,String> hl = new HashMap<>();
    if (user == null) {
        hl.put("message", "User login failed");
        return hl;
    }
    else{
        // generate jwt token
        HashMap<String, String> token = jwtUtil.generateToken(logindto);
        hl.put("AccessToken", String.valueOf(token));
        return hl;
        }
    }


    //sorting
//    public List<User> usingSorting(String field){
//        try {
//            return userRepository.findAll(Sort.by(Sort.Direction.ASC, field));
//        } catch (Exception e) {
//            throw new IllegalArgumentException("Invalid field name for sorting: " + field);
//        }
//    }

    //pagination
    public Page<User> usageOfPagination(int offset, int pageSize) {
        return userRepository.findAll(PageRequest.of(offset, pageSize));
    }

    public UserDetails loadUserByUsername(String email) {
        return null;
    }
}



