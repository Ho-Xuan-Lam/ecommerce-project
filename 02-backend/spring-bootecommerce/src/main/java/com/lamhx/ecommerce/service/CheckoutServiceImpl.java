package com.lamhx.ecommerce.service;

import java.util.Set;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.lamhx.ecommerce.dao.CustomerRespository;
import com.lamhx.ecommerce.dto.Purchase;
import com.lamhx.ecommerce.dto.PurchaseResponse;
import com.lamhx.ecommerce.entity.Customer;
import com.lamhx.ecommerce.entity.Order;
import com.lamhx.ecommerce.entity.OrderItem;

@Service
public class CheckoutServiceImpl implements CheckoutService{

	private CustomerRespository customerRespository;
	
	public CheckoutServiceImpl(CustomerRespository customerRespository) {
		this.customerRespository = customerRespository;
	}
	
	@Override
	@Transactional
	public PurchaseResponse placeOrder(Purchase purchase) {
		
		//retrieve the order info from dto
		Order order = purchase.getOrder();
		
		//generate tracking number
		String orderTrackingNumber = generateOrderTrackingNumber();
		order.setOrderTrackingNumber(orderTrackingNumber);
		
		//populate order with orderItems
		Set<OrderItem> orderItems = purchase.getOrderItems();
		orderItems.forEach(item -> order.add(item) );
		
		//populate order with billinAssress and shippingAddress
		order.setBillingAddress(purchase.getBillingAddress());
		order.setShippingAddress(purchase.getShippingAddress());
		
		//populate customer with order
		Customer customer = purchase.getCustomer();
		
		//check if this is an existing customer....
		String theEmail = customer.getEmail();
		
		Customer customerFromDB = customerRespository.findByEmail(theEmail);

		if (customerFromDB != null) {
			// we found them ... let's assign them accordingly
			customer = customerFromDB;
		}

		//
		
		//add the order to the customer
		customer.add(order);
		
		//save to the database
		customerRespository.save(customer);
		
		//return a response
		return new PurchaseResponse(orderTrackingNumber);
	}

	private String generateOrderTrackingNumber() {
		
		//generate a ramdom UUID number (UUID version-4)
		
		return UUID.randomUUID().toString();
	}

		
}
