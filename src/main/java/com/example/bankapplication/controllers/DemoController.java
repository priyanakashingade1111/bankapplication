package com.example.bankapplication.controllers;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.bankapplication.entities.Customer;

@Controller
public class DemoController {

    @RequestMapping("/")
    public String homepage(Model model){
        
       
  
        Customer customer=new Customer();
       

        model.addAttribute("customer", customer);

        return "home.html";
    }
    

    // @RequestMapping("/about")
    // public String aboutus(){
    //     return "aboutus.html";
    // }

    //  @RequestMapping("/contact")
    // public String contactus(){
    //     return "contactus.html";
    // }
    
    
   
   
}
