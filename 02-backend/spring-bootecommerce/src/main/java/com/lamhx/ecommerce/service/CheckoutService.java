package com.lamhx.ecommerce.service;

import com.lamhx.ecommerce.dto.Purchase;
import com.lamhx.ecommerce.dto.PurchaseResponse;

public interface CheckoutService {

	PurchaseResponse placeOrder(Purchase purchase);
}
