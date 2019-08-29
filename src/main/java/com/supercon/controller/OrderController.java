package com.supercon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.supercon.model.Customer;
import com.supercon.model.Product;
import com.supercon.model.ShoppingCart;
import com.supercon.service.OrderService;

@RestController
@RequestMapping(path="/api/v1/orders")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping(path="/{customerName}")
	public ResponseEntity<ShoppingCart> placeOrder(@PathVariable("customerName") String customerName, @RequestBody final List<Product> products ){
		ShoppingCart cart = orderService.placeOrder(new Customer(customerName), products);
		return new ResponseEntity<>(cart, HttpStatus.OK);
	}
	

}
