package com.codwithhossam.progicuser.servics;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codwithhossam.progicuser.dto.UserDto;
import com.codwithhossam.progicuser.enums.UserType;
import com.codwithhossam.progicuser.models.User;
import com.codwithhossam.progicuser.repo.UserRepository;

  @Service
  public class UserServic {
   @Autowired
   private UserRepository repo;
   
   public List<User> getuser(){
	   return repo.findAll();  
   } 
   
   public List<User> getuser(UserType user) { 
	   return repo.findByType(user); 
   }
    
   public User getuser(String email) {
	   return repo.findByEmail(email).get();
   } 
   
   public User CreateUser(UserDto dto) {
	   User user=new User();
	   user.setEmail(dto.getEmail());
	   user.setName(dto.getName());
	   user.setPassword(dto.getPassword()); 
	   user.setType(dto.getType());
	  
	   return repo.save(user);
   }
   
   public User UpdateUser(User user) { 
	   User user1=repo.getById(user.getId());
	   user1.setEmail(user.getEmail());
	   user1.setName(user.getName());
	   user1.setPassword(user.getPassword());
	   user1.setType(user.getType());
	   user1.setOrders(user.getOrders());
	   return repo.save(user1); 
   }
   
   public void DeleteUser() {
	   repo.deleteAll();
   } 
   
   public void DeleteUser(int id) {
	   repo.deleteById(id);
   }
   
}
