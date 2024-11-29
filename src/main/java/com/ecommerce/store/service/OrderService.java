package com.ecommerce.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.store.exceptions.NotFoundException;
import com.ecommerce.store.model.Order;
import com.ecommerce.store.repository.OrderRepository;

@Service
public class OrderService {

	 @Autowired
	    private OrderRepository orderRepository;

	   
	    public Order createOrder(Order order) {
	        return orderRepository.save(order);
	    }

	   
	    public List<Order> getAllOrders() {
	        return orderRepository.findAll();
	    }

	    
	    public Order getOrderById(Long id) {
	        return orderRepository.findById(id)
	                .orElseThrow(() -> new NotFoundException("Order with ID " + id + " not found"));
	    }

	    
	    public Order updateOrder(Long id, Order updatedOrder) {
	        Order existingOrder = getOrderById(id);

	       
	        existingOrder.setStatus(updatedOrder.getStatus());

	        return orderRepository.save(existingOrder);
	    }

	    
	    public void deleteOrder(Long id) {
	        Order existingOrder = getOrderById(id);
	        orderRepository.delete(existingOrder);
	    }
	}

