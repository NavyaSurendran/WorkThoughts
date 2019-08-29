package com.supercon.model;

import java.util.List;

public class Order {
	
	private ShoppingCart shoppingCart;
	private static final String ORDER_PLACED ="ORDER_PLACED";
	
    public Order(ShoppingCart shoppingCart, Customer customer, List<Product> products) {
        //super(customer, products, "ORDER_PLACED");
    	this.shoppingCart = shoppingCart;
    	this.shoppingCart.setCustomer(customer);
    	this.shoppingCart.setProducts(products);
    	this.shoppingCart.setCartState(ORDER_PLACED);
    }


	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}


	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}
    
    

}
