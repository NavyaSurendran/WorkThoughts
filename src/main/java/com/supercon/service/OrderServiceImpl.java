package com.supercon.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.supercon.model.Customer;
import com.supercon.model.Order;
import com.supercon.model.Product;
import com.supercon.model.ShoppingCart;

@Service
public class OrderServiceImpl implements OrderService{
	
	private Order order;

	@Override
    public ShoppingCart placeOrder( Customer customer, List<Product> products) {
        //place order
		 order =  new Order(new ShoppingCart(), customer, products);
		return order.getShoppingCart();
        //return new Order(customer, products);
    }
	
	
}
