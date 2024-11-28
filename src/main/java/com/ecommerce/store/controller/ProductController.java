package com.ecommerce.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.ecommerce.store.model.Product;
import com.ecommerce.store.service.ProductService;

@RestController
@RequestMapping("/api/products")  
public class ProductController {

    @Autowired
    private ProductService productService;

    
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product createdProduct = productService.createProduct(product);
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);  
    }

   
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
    	 List<Product> productList = productService.getAllProducts();
        return new ResponseEntity<>(productList, HttpStatus.OK); 
    }

 
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Product product = productService.getProductById(id);  
        return new ResponseEntity<>(product, HttpStatus.OK);  
    }

   
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product updatedProduct) {
        Product updated = productService.updateProduct(id, updatedProduct);  
        return new ResponseEntity<>(updated, HttpStatus.OK); 
    }

   
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);  
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);  
    }
}

