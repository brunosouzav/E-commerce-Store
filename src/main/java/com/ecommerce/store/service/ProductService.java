package com.ecommerce.store.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.store.exceptions.NotFoundException;
import com.ecommerce.store.model.Product;
import com.ecommerce.store.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

 
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

   
    public List<Product> getAllProducts() {
    	List<Product> products = productRepository.findAll();
    	return new ArrayList<>(products);
    }

  
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Product with ID " + id + " not found"));
    }

    
    public Product updateProduct(Long id, Product updatedProduct) {
      
        Product existingProduct = getProductById(id);

        existingProduct.setName(updatedProduct.getName());
        existingProduct.setDescription(updatedProduct.getDescription());
        existingProduct.setPrice(updatedProduct.getPrice());
       

        return productRepository.save(existingProduct);
    }

  
    public void deleteProduct(Long id) {
        Product existingProduct = getProductById(id);
        productRepository.delete(existingProduct);
    }
}
