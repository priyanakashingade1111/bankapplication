package com.example.bankapplication.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Accounts {
    
    @Id
    private Integer acctId;
	private Integer balance;
	private String acctStatus;
}
