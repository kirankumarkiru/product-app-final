package com.training.pms.galaxe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.Http2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.pms.galaxe.dao.ProductDAO;
import com.training.pms.galaxe.model.Product;
import com.training.pms.galaxe.service.ProductService;

@RestController
@RequestMapping("product")
public class ProductController {
	
	@Autowired
	ProductService productservice;
//@Autowired	
//ProductDAO productdao;
public ProductController() {
	
}
@GetMapping
public  ResponseEntity<List<Product>> stringgetproducts() {
//	return (List<Product>) productdao.findAll();
//	return "Getting all products";
	List<Product> products = productservice.getproduct();
	ResponseEntity<List<Product>> responseEntity;
	if(products.isEmpty()) {
		responseEntity = new ResponseEntity<List<Product>>(products, HttpStatus.NO_CONTENT);
	}
	else {
		responseEntity = new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}
	return  responseEntity;
}


@GetMapping("{productid}")

public ResponseEntity<Product> stringgetproduct(@PathVariable("productid") Integer num) {
	ResponseEntity<Product> responseEntity;
	Product message = new Product();
	if(productservice.isProductExists(num)) {
		
		message = productservice.getProduct(num);
		responseEntity = new ResponseEntity<Product>(message, HttpStatus.OK);
	
}
	else {
		
		responseEntity = new ResponseEntity<Product>(message, HttpStatus.NOT_FOUND);
	}
	return responseEntity;
}
	
@DeleteMapping("{productid}")

public ResponseEntity<String> stringdeleteproduct1(@PathVariable("productid") Integer num) {
	
	ResponseEntity<String> responseentity;
	  
	if(productservice.isProductExists(num)) {
		productservice.deleteProduct(num);
		String message = "product deleted";
		
		responseentity = new ResponseEntity<String>(message, HttpStatus.OK);
		
	}
	else {
		String message = "product cannot be deleted";
		responseentity = new ResponseEntity<String>(message, HttpStatus.NOT_FOUND);
	}
	return responseentity ;
}

@PostMapping()

public ResponseEntity<String> stringpostproduct1(@RequestBody Product product) {
//	productdao.save(product);
	
	ResponseEntity<String> responseentity;
	int pid  = product.getProductid();
	if(productservice.isProductExists(pid)) {
		responseentity = new ResponseEntity<String>("Product with product id :"+pid+" already exists", HttpStatus.CONFLICT);
	}
	else
	{
		String message = productservice.saveProduct(product);
		responseentity = new ResponseEntity<String>(message, HttpStatus.OK);
	}
	return responseentity;
	
}

@PutMapping()

public ResponseEntity<String> stringputproduct1(@RequestBody Product product) {
	ResponseEntity<String> responseentity;
	int pid  = product.getProductid();
	if(productservice.isProductExists(pid)) {
		String message = productservice.updateProduct(product);
		responseentity = new ResponseEntity<String>(message, HttpStatus.OK);
	}
	else {
		String message = "product id not found";
		responseentity = new ResponseEntity<String>(message, HttpStatus.NOT_FOUND);
	}
	return responseentity;
}

//@GetMapping("/message/{productid}")
//
//public String stringgetproductss(@PathVariable("productid") Integer num) {
//	return "Getting message product "+num;
//}
@GetMapping("searchByProductName/{productName}") // url - localhost:9090/product/2435678
public ResponseEntity<List<Product>> getProductByName(@PathVariable("productName") String productName) {

	ResponseEntity<List<Product>> responseEntity;
	List<Product> products  = productservice.searchproduct(productName);
	if(products.isEmpty()) {
		responseEntity = new ResponseEntity<List<Product>>(products, HttpStatus.NO_CONTENT);
	}
	else
	{
		responseEntity = new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}
	return responseEntity;
}



}