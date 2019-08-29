package com.supercon.service;

import java.util.List;

import com.supercon.model.Customer;
import com.supercon.model.Product;


public interface ShoppingCartService {

	public void checkout(Customer customer, List<Product> products);
	
	public void showConfirmation(Customer customer, List<Product> products, double totalPrice, int loyaltyPointsEarned);

}
