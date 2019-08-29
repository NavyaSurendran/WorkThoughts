package com.supercon.service;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.supercon.model.Customer;
import com.supercon.model.Product;
import com.supercon.model.ShoppingCart;

public class OrderServiceTest {

	private OrderService orderService;
	private Customer customer;
	private List<Product> products;
	
	@Before
	public void setUp() {
		
	  products = Arrays.asList(new Product(1.50, "PROD_01", "Product 01"),
                new Product(3.45, "PROD_02", "Product 02"));
	  customer = new Customer("Navya");
	  
	}
	
	@Test
	public void placeOrderShouldReturnShoppingCart(){
		
		orderService = new OrderServiceImpl();
		ShoppingCart shoppingCart = orderService.placeOrder(new ShoppingCart(), customer, products);
		assertEquals(shoppingCart.getProducts().get(0).getProductCode(), "PROD_01");
		assertEquals(shoppingCart.getProducts().get(1).getProductCode(), "PROD_02");
		assertEquals(shoppingCart.getCustomer().getName(), "Navya");
		assertEquals(shoppingCart.getCartState(), "ORDER_PLACED");
	}
}
