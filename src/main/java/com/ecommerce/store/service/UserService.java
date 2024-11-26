package com.ecommerce.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.store.exceptions.UserNotFoundException;
import com.ecommerce.store.model.User;
import com.ecommerce.store.repository.UserRepository;

@Service
public class UserService {

	@Autowired
    private UserRepository userRepository;

  
    public User createUser(User user) {
        return userRepository.save(user);
    }

    
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

   
    public User getUserById(Long id) {
        return userRepository.findById(id)
        		.orElseThrow(() -> new UserNotFoundException("User with ID " + id + " not found"));
    }

 
    public User updateUser(Long id, User updatedUser) {
        
        User existingUser = getUserById(id);
        
        existingUser.setPassword(updatedUser.getPassword());  
        existingUser.setEmail(updatedUser.getEmail());   
        
        return userRepository.save(updatedUser);
    }

   
    public void deleteUser(Long id) {
    	User existingUser = getUserById(id);
    	
    	userRepository.delete(existingUser);
    
    }
}