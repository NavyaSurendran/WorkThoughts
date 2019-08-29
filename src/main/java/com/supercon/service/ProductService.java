package com.supercon.service;

import java.util.List;

import com.supercon.model.Product;


public interface ProductService {

	public List<String> getProductCodes();
	
	public Product getProduct(final String code);
}
