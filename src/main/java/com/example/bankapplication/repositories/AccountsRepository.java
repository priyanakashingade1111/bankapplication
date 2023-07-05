package com.example.bankapplication.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.bankapplication.entities.Accounts;
import com.example.bankapplication.entities.User;

import jakarta.transaction.Transactional;
@Repository
 public interface AccountsRepository extends JpaRepository<Accounts, Integer> {
	// @Query("select balance from Accounts where acctID = ?1")
     //public int findBalanceByAcctID(int acctID);

	@Transactional
	 @Modifying
   @Query(value = "update Accounts set balance = balance+ ?2 where acctId= ?1")
	  public void saveBalanceByAcctID(Integer acctID, Integer balance);
    
	@Transactional
	 @Modifying
	 @Query(value = "update Accounts set balance = balance - ?2 where acctId= ?1")
	   public void withdrawAmountByAcctID(Integer acctID, Integer balance);

   
    
 

	
}
