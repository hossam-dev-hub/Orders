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

import com.codwithhossam.progicuser.dto.OrdersDto;
import com.codwithhossam.progicuser.models.Orders;
import com.codwithhossam.progicuser.repo.ProdecRepository;
import com.codwithhossam.progicuser.repo.UserRepository;
import com.codwithhossam.progicuser.servics.OrdersServic;

  @RestController
   @RequestMapping("/Orders")
   public class OrdersController {
   
	  @Autowired
	  private OrdersServic ser;
	  
	  @Autowired
	    private UserRepository userRepo;

	    @Autowired
	    private ProdecRepository productRepo;
	  
	  @GetMapping("/getAllOrders")
 	 public List<Orders> getorders(){
 		   return ser.getorders();
 	   }
 	 
 	 @GetMapping("/getid/{id}")
 	 public Orders getorders(@PathVariable int id) {
 		 return ser.getorders(id);
 	 } 
 	 
     @PostMapping("/CreateOrders")
     public Orders Createorders(@RequestBody OrdersDto dto) {
     	return ser.Createorders(dto);
     }
     
     @PutMapping("/UpdateOrders/")
     public Orders UpdateUser(Orders ord) {
     	return ser.Updateorders(ord);
     }
     @DeleteMapping("/deleteallOrders")
     public void DeleteOrders() {
  	   ser.Deleteorders();
     }
     
     @DeleteMapping("/delete/{id}")
     	public void DeleteOrders(@PathVariable int id) {
     		ser.DeleteOrders(id);
     		
         }  
}
