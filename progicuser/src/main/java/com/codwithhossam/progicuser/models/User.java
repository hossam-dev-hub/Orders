   package com.codwithhossam.progicuser.models;

import java.util.List;

import com.codwithhossam.progicuser.enums.UserType;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

  @Entity
   @Table(name="USERS")
   public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   	  private int id ;
      private String name;
      private String email;
      private String password;
      
      @Enumerated(EnumType.STRING)
      private UserType type;
      
      @OneToMany(mappedBy="custemer")
	   @JsonIgnore
	   private List<Orders>Orders; 
      
      @OneToMany(mappedBy="Serller") 
	   @JsonIgnore 
	   private List<Orders>SerllerOrders; 
      
	  public int getId() {
		  return id;
	  }

	  public void setId(int id) {
		  this.id = id;
	  }

	 

	 

	
	  public String getPassword() {
		  return password;
	  }

	  public void setPassword(String password) {
		  this.password = password;
	  }

	  public UserType getType() {
		  return type;
	  }

	  public void setType(UserType type) {
		  this.type = type;
		  
	  }

	  public String getName() {
		  return name;
	  }

	  public void setName(String name) {
		  this.name = name;
	  }

	  public String getEmail() {
		  return email;
	  }

	  public void setEmail(String email) {
		  this.email = email;
	  }


	  public List<Orders> getSerllerOrders() {
		  return SerllerOrders;
	  }

	  public void setSerllerOrders(List<Orders> serllerOrders) {
		  SerllerOrders = serllerOrders;
	  }

	  public List<Orders> getOrders() {
		  return Orders;
	  }

	  public void setOrders(List<Orders> orders) {
		  Orders = orders;
	  }
  }
