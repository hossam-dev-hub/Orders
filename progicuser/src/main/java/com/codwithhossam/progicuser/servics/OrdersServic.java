  package com.codwithhossam.progicuser.servics;

  import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codwithhossam.progicuser.dto.OrderItemDto;
import com.codwithhossam.progicuser.dto.OrdersDto;
import com.codwithhossam.progicuser.models.Orders;
import com.codwithhossam.progicuser.models.User;
import com.codwithhossam.progicuser.models.prodect;
import com.codwithhossam.progicuser.repo.OrdersRepository;
import com.codwithhossam.progicuser.repo.ProdecRepository;
import com.codwithhossam.progicuser.repo.UserRepository;

  @Service
  public class OrdersServic {
   @Autowired
   private OrdersRepository repo;
   
   @Autowired
   private ProdecRepository productRepo;
   
   @Autowired
   private UserRepository use;
   
   public List<Orders> getorders(){ 
	   return repo.findAll();  
   } 
    
   public Orders getorders(int id) {
	   return repo.findById(id).get();
   } 
   
   public Orders Createorders(OrdersDto dto) { 
	   User customer = use.findById(dto.getCustomerId())
	            .orElseThrow(() -> new RuntimeException("العميل غير موجود"));

	    User seller = use.findById(dto.getSellerId())
	            .orElseThrow(() -> new RuntimeException("البائع غير موجود"));

	    // 2. إنشاء كائن الطلب الجديد
	    Orders ord = new Orders();
	    ord.setCustemer(customer);
	    ord.setSerller(seller);

	    double totalPrice = 0.0;

	    // 3. التكرار على جميع المنتجات المطلوبة لحساب السعر الإجمالي
	    if (dto.getItems() != null && !dto.getItems().isEmpty()) {
	        for (OrderItemDto item : dto.getItems()) {
	            // جلب المنتج للتأكد من وجوده ومعرفة سعره
	            prodect dbProduct = productRepo.findById(item.getProductId())
	                    .orElseThrow(() -> new RuntimeException("المنتج رقم " + item.getProductId() + " غير موجود"));

	            int quantity = item.getQuantity() > 0 ? item.getQuantity() : 1;

	            // إضافة سعر المنتج * كميته إلى المجموع الكلي
	            totalPrice += (dbProduct.getPrice() * quantity);
	        }
	    }

	    // 4. تعيين السعر الإجمالي النهائي وحفظ الطلب
	    ord.setTotalPrice(totalPrice);
	    return repo.save(ord);
	}
  
   public Orders Updateorders(Orders ord) { 
	   return repo.save(ord);
   }
   
   public void Deleteorders() {
	   repo.deleteAll();
   } 
   
   public void DeleteOrders(int id) {
	   repo.deleteById(id);
   }
   
}
