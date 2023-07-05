package com.example.bankapplication.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.bankapplication.entities.Login;
import com.example.bankapplication.services.LoginService;



@Controller
public class LoginController {

    @Autowired
    LoginService loginService;

    @RequestMapping("/loginpage")
   public String adminlogin(Model model){

    

 return "login.html";}

  
}
