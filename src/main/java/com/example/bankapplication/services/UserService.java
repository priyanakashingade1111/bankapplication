 package com.example.bankapplication.services;

import java.util.Optional;


 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Service;


 import com.example.bankapplication.entities.User;

 import com.example.bankapplication.repositories.UserRepository;

 @Service
 public class UserService {
     @Autowired
 	private   UserRepository userRepository;


      public  Optional<User> findById(String name) {
           return userRepository.findById(name);
        }     

 }
