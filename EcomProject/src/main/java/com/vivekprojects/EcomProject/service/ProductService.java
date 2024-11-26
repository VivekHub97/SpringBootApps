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

	public void addProduct(Product product) {
		// TODO Auto-generated method stub
		repo.save(product);
			
	}

	public Product getProductById(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElse(null);
	}

	public void deleteProductById(int id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
		
	}

	public void updateProduct(Product product, int id) {
		// TODO Auto-generated method stub
		
//		Product prevProd = getProductById(id);
//		prevProd.setId(id);
//		prevProd.setAvailable(product.isAvailable());
//		prevProd.setBrand(product.getBrand());
//		prevProd.setDesc(product.getDesc());
//		prevProd.setName(product.getName());
//		prevProd.setPrice(product.getPrice());
//		prevProd.setReleaseDate(product.getReleaseDate());
		
		repo.save(product);
			
	}

	public List<Product> searchProducts(String keyword) {
		// TODO Auto-generated method stub
		return repo.searchProducts(keyword);
	}
	
	

}
