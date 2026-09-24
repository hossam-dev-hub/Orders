package com.codwithhossam.progicuser.dto;

import java.util.List;

import lombok.Data;

@Data
public class OrdersDto {
	
    private int customerId;
    private int sellerId;
    private List<OrderItemDto> items;
}
