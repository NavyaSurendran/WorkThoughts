package com.supercon.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.supercon.model.Customer;
import com.supercon.model.Product;
import com.supercon.model.ShoppingCart;
import com.supercon.service.OrderService;

@RunWith(SpringRunner.class)
@WebMvcTest(OrderController.class)
public class OrderControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private OrderService orderService;
	
	private List<Product> products;
	
	private Customer customer;
	
	public void setUp() {
		products = Arrays.asList(
	            new Product(24.99, "CHAIR_RED", "Red plastic chair"),
	            new Product(24.99, "DIS_10-CHAIR_BLUE", "Blue plastic chair"),
	            new Product(24.99, "CHAIR_WHITE", "White plastic chair"),
	            new Product(249.99, "BOARD_TABLE", "12-person boardroom table"),
	            new Product(99.99, "BOARD_CHAIR", "Boardroom chair")
	    );
		customer = new Customer("Navya");
	}
	
	
	public void testPlaceOrderWIthProperCustomerNameAndProducts() {
		ShoppingCart cart = new ShoppingCart(customer, products, "PLACED");
	
		when(orderService.placeOrder(customer, products)).thenReturn(cart);
		mvc.perform(post("/api/v1/orders/{customerName}", "Navya"))
		.andExpect(status().isOk())
        .andExpect(content().json(CHAIR_RED_JSON));
	}
	

}
