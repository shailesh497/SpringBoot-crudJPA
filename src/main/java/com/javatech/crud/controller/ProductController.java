package com.javatech.crud.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javatech.crud.entity.Product;
import com.javatech.crud.service.ProductService;

@RestController
public class ProductController {
	@Autowired
	private ProductService service;
	
	@RequestMapping("*")
	public String Start() {
		return("Hello world");
	}

	@PostMapping("/addProduct")
	public Product addProduct(@RequestBody Product product) {
		return service.saveProduct(product);
	}

	@PostMapping("/addProducts")
	public List<Product> addPRODUCTS(@RequestBody List<Product> product) {
		return service.saveProducts(product);
	}

	@GetMapping("/products")
	public List<Product> findAllProducts() {
		return service.getProduct();

	}

	@GetMapping("/product/{id}")
	public Product findProductById(@PathVariable int id) {
		return service.getProductById(id);

	}

	@GetMapping("/productName/{name}")
	public Product findProductByName(@PathVariable String name) {
		return service.getProductByName(name);

	}

	@PutMapping("/update")
	public Product updateProduct(@RequestBody Product product) {
		return service.updateProduct(product);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteProduct(@PathVariable int id) {
		service.deleteProduct(id);
		return "deleted the data";
	}

}
