package com.ecommerce.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.store.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
