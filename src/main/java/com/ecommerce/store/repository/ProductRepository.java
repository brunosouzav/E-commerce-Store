package com.ecommerce.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.store.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
