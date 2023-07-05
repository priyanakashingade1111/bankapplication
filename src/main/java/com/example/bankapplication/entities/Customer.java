package com.example.bankapplication.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.TableGenerator;
import lombok.Data;

@Data
@Entity
public class Customer {
	@TableGenerator(name="account_gen",pkColumnName = "acctId",initialValue = 1000000000)
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE,generator="account_gen")
    private  Integer acctId;
    private String custName;
	private String city;
	private String state;
	private String country;
	private Long phoneNo;
	private String password; 
}
