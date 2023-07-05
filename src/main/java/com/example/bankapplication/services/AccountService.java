package com.example.bankapplication.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bankapplication.entities.Accounts;
import com.example.bankapplication.entities.Customer;
import com.example.bankapplication.entities.User;
import com.example.bankapplication.repositories.AccountsRepository;

@Service
public class AccountService {
    @Autowired
	private AccountsRepository accountRepository;

	public Iterable<Accounts> getAll(){
             return this.accountRepository.findAll();
        }

	public void createAccount(Accounts acct) {
		accountRepository.save(acct);
	}

    public Optional<Accounts> findById(Integer accountNumber1) {
        return accountRepository.findById(accountNumber1);
    }
	

	 public void depositAmount(Integer acctID, Integer amount) {
		accountRepository.saveBalanceByAcctID(acctID, amount);
	 }

	public void withdrawAmount(Integer acctID, Integer amount) {
		accountRepository.withdrawAmountByAcctID(acctID, amount);
	}

	public void transferAmount(Integer acctID, Integer destAcctID, Integer amount) {
		accountRepository.withdrawAmountByAcctID(acctID, amount);
		accountRepository.saveBalanceByAcctID(destAcctID, amount);
	}

	

}
