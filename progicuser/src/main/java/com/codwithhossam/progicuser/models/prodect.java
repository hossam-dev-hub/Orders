   package com.codwithhossam.progicuser.models;

   import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
   import jakarta.persistence.GenerationType;
  import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
       @Entity
      public class prodect {
	   @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
    	private int id;
    	private String name;
    	private double price;
    	private int counter =0;
    	
    	@OneToMany(mappedBy ="prodect")
    	@JsonIgnore
    	private List<Orders>prodectOrders;
    	
    	
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getCounter() {
			return counter;
		}
		public void setCounter(int counter) {
			this.counter = counter;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		public List<Orders> getProdectOrders() {
			return prodectOrders;
		}
		public void setProdectOrders(List<Orders> prodectOrders) {
			this.prodectOrders = prodectOrders;
		}
   }
