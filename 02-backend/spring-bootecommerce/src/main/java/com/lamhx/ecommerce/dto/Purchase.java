package com.lamhx.ecommerce.dto;

import java.util.Set;

import com.lamhx.ecommerce.entity.Address;
import com.lamhx.ecommerce.entity.Customer;
import com.lamhx.ecommerce.entity.Order;
import com.lamhx.ecommerce.entity.OrderItem;

import lombok.Data;

@Data
public class Purchase {

	private Customer customer;
	private Address shippingAddress;
	private Address billingAddress;
	private Order order;
	private Set<OrderItem> orderItems; 
	
}
