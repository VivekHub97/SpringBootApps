package com.vivekprojects.EcomProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	public ResponseEntity<List<Product>> getAllProducts() {
		return new ResponseEntity<>(service.getAllProducts(), HttpStatus.OK);
	}

	@GetMapping("/product/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable int id) {

		Product product = service.getProductById(id);
		if (product != null) {
			return new ResponseEntity<>(product, HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}

	@PostMapping("/addProduct")
	public ResponseEntity<?> addProduct(@RequestBody Product product) {

		try {
			service.addProduct(product);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	@DeleteMapping("/product/{id}")
	public ResponseEntity<?> deleteProductById(@PathVariable int id) {

		service.deleteProductById(id);
		return new ResponseEntity<>(HttpStatus.OK);

	}
	
	@PutMapping("/product/{id}")
	public ResponseEntity<?> updateProduct(@RequestBody Product product, @PathVariable int id) {

			service.updateProduct(product, id);
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}

}
