   package com.codwithhossam.progicuser.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

   @Entity
   public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	   private int id ;
    private int quantity;
    
    private double totalPrice;
    
    @ManyToOne
    @JoinColumn(name="prodect_id")
    private prodect prodect;
    
    @ManyToOne 
    @JoinColumn(name="custemer_id")
    private User custemer; 
    
    @ManyToOne
    @JoinColumn(name="Serller_id")
    private User Serller;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id; 
	}

	public prodect getProdect() {
		return prodect;
	}

	public void setProdect(prodect prodect) {
		this.prodect = prodect;
	}

	public User getCustemer() {
		return custemer;
	}

	public void setCustemer(User custemer) {
		this.custemer = custemer;
	}

	public User getSerller() {
		return Serller;
	}

	public void setSerller(User serller) {
		Serller = serller;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	
    
    
   }
