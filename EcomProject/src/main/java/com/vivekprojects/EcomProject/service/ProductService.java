package com.vivekprojects.EcomProject.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vivekprojects.EcomProject.model.Product;
import com.vivekprojects.EcomProject.repo.ProductRepo;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepo repo;

	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		System.out.println(repo.findAll());
		return repo.findAll();
	}

	public void addProduct() {
		// TODO Auto-generated method stub
		repo.save(new Product());
		
		
	}

	public Product getProductById(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElse(null);
	}
	
	

}
