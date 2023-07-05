package com.example.bankapplication.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.bankapplication.entities.Accounts;
import com.example.bankapplication.entities.Customer;
import com.example.bankapplication.entities.User;
import com.example.bankapplication.services.AccountService;
import com.example.bankapplication.services.UserService;


@Controller
public class AccountController {
	@Autowired
	private AccountService accountService;
     @Autowired
	 private UserService userService;
	

	@RequestMapping(path = "/admin")
	public String login(@RequestParam("name") String name, @RequestParam("password") String password,Model model) {
		Optional<User> user =userService.findById(name);
     if(user.isPresent()){
		

 		return "adminpage.html";
   }else{
      model.addAttribute("message", "User is not present");
      return "login.html";
 	    }
	}

	@RequestMapping("/info")
	public String getAllAccounts(Model model) {
		model.addAttribute("accounts", this.accountService.getAll());
		return "accountinfo.html";
	}

	
	public void createAccount(Integer acctID, Integer balance, String acctStatus) {
		Accounts acct = new Accounts(acctID, balance, acctStatus);
		accountService.createAccount(acct);
	}

	@RequestMapping(path = "/checkbalance/{accountNumber}")
	public String login(@PathVariable("accountNumber") String accountNumber, Model model) {
		System.out.println(accountNumber);
		System.out.println("===============================");
		Integer accountNumber1 = Integer.parseInt(accountNumber);

		Optional<Accounts> account = accountService.findById(accountNumber1);
		System.out.println(account.get().getBalance());
		model.addAttribute("balance", account.get().getBalance());
		return "checkbalance.html";
	}

	@RequestMapping(path = "/transferamount")
	public String login(@RequestParam("fromaccount") Integer fromaccount, @RequestParam("toaccount") Integer toaccount,
			@RequestParam("amount") Integer amount, Model model) {
		System.out.println(fromaccount);
		System.out.println(toaccount);
		System.out.println(amount);
		try {
			accountService.transferAmount(fromaccount, toaccount, amount);
			model.addAttribute("serverMessage", "Blance transfer successfully");
			
			return "customerpage.html";
		} catch (Exception e) {
			model.addAttribute("serverMessage", "Error in balance transfer ");
			
			return "customerpage.html";

		}
	}

	@RequestMapping("/transfer")
	public String transferamount() {
		return "transfer.html";
	}

	@RequestMapping(path = "/dipositamount")
	public String diposit(@RequestParam("accountNumber") Integer accountNumber, @RequestParam("amount") Integer amount,
			Model model) {
		System.out.println(accountNumber);

		System.out.println(amount);
       
		try {
		accountService.depositAmount(accountNumber, amount);
		model.addAttribute("serverMessage1", "Blance diposited successfully");
			
			return "customerpage.html";
		} catch (Exception e) {
			model.addAttribute("serverMessage1", "Error in balance diposit ");
			
			return "customerpage.html";

		}
	}

	@RequestMapping("/diposit")
	public String dipositamount() {
		return "dipositamount.html";
	}

	@RequestMapping(path = "/withdrawamount")
	public String withdraw(@RequestParam("accountNumber") Integer accountNumber, @RequestParam("amount") Integer amount,
			Model model) {
		System.out.println(accountNumber);

		System.out.println(amount);

		try {
		accountService.withdrawAmount(accountNumber, amount);
		model.addAttribute("serverMessage2", "Blance withdrow successfully");
			
			return "customerpage.html";
		} catch (Exception e) {
			model.addAttribute("serverMessage2", "Error in balance withdrow ");
			
			return "customerpage.html";

		}
	}

	@RequestMapping("/withdraw")
	public String withdrawamount() {
		return "withdrawamount.html";
	}
	
}
