    package com.codwithhossam.progicuser.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codwithhossam.progicuser.dto.UserDto;
import com.codwithhossam.progicuser.enums.UserType;
import com.codwithhossam.progicuser.models.User;
import com.codwithhossam.progicuser.servics.UserServic;

     @RequestMapping("/Users")
     @RestController
    public class Usercontroller {
      
    	 @Autowired
    	 private UserServic ser;
    	 
    	 @GetMapping("/getAllUser")
    	 public List<User> getuser(){
    		   return ser.getuser();
    	   }
    	 
    	 @GetMapping("/getUserType/{role}")
    	 public List<User> getuser(@PathVariable UserType userT){
    		 return ser.getuser(userT);
    	 }
    	 
    	 @GetMapping("/getemail/{email}")
    	 public User getuser(@PathVariable String email) {
    		 return ser.getuser(email); 
    	 }
    	 
        @PostMapping("/CreateUser")
        public User CreateUser(@RequestBody UserDto us) {
        	return ser.CreateUser(us);
        }
        
        @PutMapping("/UpdateUser/")
        public User UpdateUser(@RequestBody User us) {
        	return ser.UpdateUser(us); 
        }
        @DeleteMapping("/deleteallUser")
        public void DeleteUser() {
     	   ser.DeleteUser();
        }
        
        @DeleteMapping("/deleteUser/{id}")
        	public void DeleteUser(@PathVariable int id) {
        		ser.DeleteUser(id);
        		
            }  
        
        
    }
