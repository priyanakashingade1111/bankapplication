package com.example.bankapplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.bankapplication.entities.Customer;

@Repository
public interface CustomerRepository 
   extends CrudRepository<Customer,Integer>,JpaRepository<Customer,Integer>{
    
}
