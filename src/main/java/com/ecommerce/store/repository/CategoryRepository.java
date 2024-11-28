package com.ecommerce.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.store.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
