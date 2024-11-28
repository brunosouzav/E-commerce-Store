package com.ecommerce.store.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "categories")
public class Category {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;
	
	private String name;
	
	@ManyToMany(mappedBy = "categories")
	@JsonBackReference
	private List<Product> products = new ArrayList<>();
	
	public Category(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	
}
