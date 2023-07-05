package com.example.bankapplication.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.example.bankapplication.entities.Customer;
import com.example.bankapplication.entities.Login;
import com.example.bankapplication.repositories.LoginRepository;


@Service
public class LoginService {
    
    @Autowired
   LoginRepository loginRepository;

   

    public List<Login> getLogin() {
        List<Login> userlist= loginRepository.findAll();
      return userlist;
    }
}