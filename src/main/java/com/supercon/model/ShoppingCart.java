package com.supercon.model;

import java.util.List;

public class ShoppingCart {

    //Product and quantity
    private List<Product> products;
    private Customer customer;
    private String cartState;
   

	public ShoppingCart() {
		
	}

    public ShoppingCart(Customer customer, List<Product> products, String cartState) {
        this.customer = customer;
        this.products = products;
        this.cartState = cartState;
    }

    public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getCartState() {
		return cartState;
	}

	public void setCartState(String cartState) {
		this.cartState = cartState;
	}

	

}
