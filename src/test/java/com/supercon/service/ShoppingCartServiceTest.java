package com.supercon.service;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.supercon.model.Customer;
import com.supercon.model.Product;

public class ShoppingCartServiceTest {
	
	private ShoppingCartService service;
	private Customer customer;
	private List<Product> products;
	
	@Before
	public void setUp() {
		 products = Arrays.asList(new Product(1.50, "PROD_01", "Product 01"),
	                new Product(3.45, "PROD_02", "Product 02"));
		  customer = new Customer("Navya");
		
	}
	
	@Test
	public void testCheckoutWithProperCustomerAndProducts() {
		service = new ShoppingCartServiceImpl();
		service.checkout(customer, products);
	}

}
