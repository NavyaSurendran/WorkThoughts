package com.supercon.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.supercon.model.Customer;
import com.supercon.model.Product;
import com.supercon.model.ShoppingCart;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

	private ShoppingCart shoppingCart;
	
	@Override
	public void checkout(Customer customer, List<Product> products) {
		shoppingCart = new ShoppingCart(customer, products, "OPEN");

		checkout();
	}

	/*
	 * Checkout: Calculates total price and total loyalty points earned by the
	 * customer. Products with product code starting with DIS_10 have a 10% discount
	 * applied. Products with product code starting with DIS_15 have a 15% discount
	 * applied.
	 * 
	 * Loyalty points are earned more when the product is not under any offer.
	 * Customer earns 1 point on every $5 purchase. Customer earns 1 point on every
	 * $10 spent on a product with 10% discount. Customer earns 1 point on every $15
	 * spent on a product with 15% discount.
	 */

	public void checkout() {
		double totalPrice = 0;

		int loyaltyPointsEarned = 0;
		for (Product product : shoppingCart.getProducts()) {
			double discount = 0;
			if (product.getProductCode().startsWith("DIS_10")) {
				discount = (product.getPrice() * 0.1);
				loyaltyPointsEarned += (product.getPrice() / 10);
			} else if (product.getProductCode().startsWith("DIS_15")) {
				discount = (product.getPrice() * 0.15);
				loyaltyPointsEarned += (product.getPrice() / 15);
			} else {
				loyaltyPointsEarned += (product.getPrice() / 5);
			}

			totalPrice += product.getPrice() - discount;
		}

	    showConfirmation(shoppingCart.getCustomer(), shoppingCart.getProducts(), totalPrice, loyaltyPointsEarned);
	}
	
	@Override
	public void showConfirmation(Customer customer, List<Product> products, double totalPrice, int loyaltyPointsEarned) {
        //show confirmation
        //do some calculations and formatting on the shopping cart data and ask user for confirmation
        //after confirmation redirect to place order
    }

	public void addProduct(Product product) {
		shoppingCart.getProducts().add(product);
	}

	public void removeProduct(Product product) {
		shoppingCart.getProducts().remove(product);
	}
}
