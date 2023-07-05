// package com.example.bankapplication.controllers;

// import java.util.Optional;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;

// import com.example.bankapplication.entities.User;
// import com.example.bankapplication.services.UserService;

// @Controller
// public class UserController {
    
//      @Autowired
//      private AccountController accountController;

//     @Autowired
//        private UserService userService;

//     @RequestMapping(path = "/admin")
// 	public String login(@RequestParam("name") String name, @RequestParam("password") String password,Model model) {
// 		Optional<User> user =UserService.findByname(name);
//        if(user.isPresent()){
		

// 		return "adminpage.html";

// 	   }else{

// 		return "login.html";
// 	   }
// 	}
// }
