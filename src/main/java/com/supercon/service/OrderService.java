package com.supercon.service;

import java.util.List;

import com.supercon.model.Customer;
import com.supercon.model.Order;
import com.supercon.model.Product;
import com.supercon.model.ShoppingCart;


public interface OrderService {


    public ShoppingCart placeOrder(Customer customer, List<Product> products);

}
