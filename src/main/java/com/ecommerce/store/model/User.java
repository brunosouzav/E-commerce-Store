package com.ecommerce.store.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;
    
    
    @NotBlank(message = "Name cannot be blank") 
    @Size(max = 100, message = "Name cannot exceed 100 characters") 
    private String name;
    
    @Email
    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Email should be valid") 
    private String email;
    
    @NotBlank(message = "Password cannot be blank") 
    @Size(min = 8, max = 50, message = "Password must be between 8 and 50 characters") 
    private String password;
    
    @JsonIgnore
	@OneToMany(mappedBy = "client")
	private List<Order> orders = new ArrayList<>();
}