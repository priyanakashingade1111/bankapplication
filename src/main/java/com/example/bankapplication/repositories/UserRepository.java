package com.example.bankapplication.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.bankapplication.entities.User;

@Repository
public interface UserRepository 
   extends JpaRepository<User,String>{

   

    
  
    
}
