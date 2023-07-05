package com.example.bankapplication.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;


import com.example.bankapplication.entities.Customer;
import com.example.bankapplication.services.CustomerService;


@Controller
public class CustomerController {
    
    @Autowired
    private CustomerService customerService;


    	@Autowired
	private AccountController accountController;

    @Autowired
    private LoginController loginController;

    @RequestMapping("/view")
    public String getAllCustomer(Model model){
        model.addAttribute("customers", this.customerService.getAll());
        return "viewCustomer.html";
    }



    @RequestMapping("/add")
    public String addCustomer(Model model){
        model.addAttribute("customer", new Customer());
     
        return "addcustomer.html";
    }

    
   @RequestMapping("/custdetails/{accId}")
   public String customerlogin(@PathVariable String accId){
   Optional<Customer> customer= customerService.findById(Integer.parseInt(accId));
   System.out.println(customer.get().getCity());
   System.out.println(customer.get().getCustName());

System.out.println(customer.get().getState());
//Model.addAttribute("customer", customer);
 return "login.html";
 //return "customerpage.html";
   }

    @RequestMapping(path="/customerdetails")
    public String login(@RequestParam("accountNumber") Integer accountNumber,Model model){
        System.out.println(accountNumber);
        
       Optional<Customer> customer =customerService.findById(accountNumber);
       if(customer.isPresent()){
	   System.out.println( customer.get().getCustName());
       model.addAttribute("accountNumber", customer.get().getAcctId());
       model.addAttribute("name", customer.get().getCustName());
       model.addAttribute("city", customer.get().getCity());
       model.addAttribute("state", customer.get().getState());
       model.addAttribute("phoneno", customer.get().getPhoneNo());
        model.addAttribute("password", customer.get().getPassword());
        return "customerpage.html";}
else{
    model.addAttribute("message", "Customer is not present please enter valid account number or create account ");

 return "customerlogin.html";
}    
}
    
    // @RequestMapping("/loginpage")
    // public String login(){

    //     return "login.html";
    // }

     @RequestMapping("/custlogin")
    public String customerlogin(){
        return "customerlogin.html";
    }

    // @RequestMapping("/back")
    // public String check(){
    //     return "customerpage.html";
    // }



    @RequestMapping("/addcustomer")
    public String addCustomerDone(@ModelAttribute Customer customer,Model model){
        Customer newCustomer = this.customerService.addCustomer(customer);
         accountController.createAccount(newCustomer.getAcctId() , 0, "Active");
         model.addAttribute("accountNumber", newCustomer.getAcctId());
       model.addAttribute("name", newCustomer.getCustName());
       model.addAttribute("city", newCustomer.getCity());
       model.addAttribute("state", newCustomer.getState());
       model.addAttribute("phoneno", newCustomer.getPhoneNo());
       model.addAttribute("password",newCustomer.getPassword());
         return "customerdetails.html";
    }

    @RequestMapping("/delete/{acctId}")
    public String deleteCustomer(@PathVariable Integer acctId){
        this.customerService.deleteCustomer(acctId);
        return "redirect:/view";

    }

    @RequestMapping("/update/{acctId}")
    public String updateCustomer(Model model, @PathVariable Integer acctId){
        model.addAttribute("customer", this.customerService.searchCustomer(acctId));
        return "updatecustomer.html";
    }

    @RequestMapping("/updatecustomer")
    public String updateCustomerDone(@ModelAttribute Customer customer){
        this.customerService.updateCustomer(customer);
        return "redirect:view";
    }
   
}
