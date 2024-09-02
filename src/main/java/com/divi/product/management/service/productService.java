package com.divi.product.management.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.divi.product.management.Repository.productRepository;
import com.divi.product.management.models.product;

@Service
public class productService {
	
	@Autowired
	private productRepository productRepo;
	
	public product saveProduct(product ent)
	{
		ent.setId(UUID.randomUUID().toString().split("-")[0]);
		return productRepo.save(ent);
	}
	
	public List<product> findAllProducts()
	{
		return productRepo.findAll();
	}
	

}
