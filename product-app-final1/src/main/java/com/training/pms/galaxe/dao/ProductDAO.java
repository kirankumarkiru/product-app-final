package com.training.pms.galaxe.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.training.pms.galaxe.model.Product;

public interface ProductDAO extends CrudRepository<Product, Integer>{
	public List<Product> findByProductName(String productName);	
	
	
}
