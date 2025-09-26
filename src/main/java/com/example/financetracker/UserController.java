package com.example.financetracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public String registerUser(@RequestBody User user){
        if(userRepository.findByEmail(user.getEmail())!=null){
            return "Email already registered!";
        }
        else{
            userRepository.save(user);
            return "User registered successfully!";
        }
    }
}
