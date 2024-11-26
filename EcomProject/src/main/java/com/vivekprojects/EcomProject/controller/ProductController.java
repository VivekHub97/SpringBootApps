package com.vivekprojects.EcomProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vivekprojects.EcomProject.model.Product;
import com.vivekprojects.EcomProject.service.ProductService;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@RequestMapping("/")
	public String greet() {
		return "Hello !";
	}
	
	@GetMapping("/products")
	public List<Product> getAllProducts(){
		return service.getAllProducts();
	}
	
	@PostMapping("/addProduct")
	public void addProduct(){
		service.addProduct();
	}

}
