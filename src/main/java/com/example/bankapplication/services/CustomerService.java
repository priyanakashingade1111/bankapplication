package com.example.bankapplication.services;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bankapplication.entities.Customer;
import com.example.bankapplication.repositories.CustomerRepository;

@Service
public class CustomerService {
    private Map<Integer, Customer>customerMap=new HashMap<>();
  //  private AtomicInteger atomic=new AtomicInteger();

    public CustomerService(){
        
        
        }

        @Autowired
        private CustomerRepository customerRepository;

       

        public Iterable<Customer> getAll(){
             return this.customerRepository.findAll();
        }
        
        public Customer addCustomer(Customer newCustomer){
           
       Customer customer= this.customerRepository.save(newCustomer);
          return customer;

        }

        public void deleteCustomer(Integer acctId){
           
           this.customerRepository.deleteById(acctId);
        }

        public Customer searchCustomer(Integer acctId){
           
           return this.customerRepository.findById(acctId).get();
                }

        public void updateCustomer(Customer customer){
          
            this.customerRepository.save(customer);
        }

        public Optional<Customer> findById(Integer accId) {
           return this.customerRepository.findById(accId);
        }

        public void findByAccountNumber(String accountNumber) {
        }
}

