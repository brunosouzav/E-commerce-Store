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

import com.ecommerce.store.model.Order;
import com.ecommerce.store.service.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

	 @Autowired
	    private OrderService orderService;

	    
	    @PostMapping
	    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
	        Order createdOrder = orderService.createOrder(order);
	        return new ResponseEntity<>(createdOrder, HttpStatus.CREATED);
	    }

	 
	    @GetMapping
	    public ResponseEntity<List<Order>> getAllOrders() {
	        List<Order> orderList = orderService.getAllOrders();
	        return new ResponseEntity<>(orderList, HttpStatus.OK);
	    }

	
	    @GetMapping("/{id}")
	    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
	        Order order = orderService.getOrderById(id);
	        return new ResponseEntity<>(order, HttpStatus.OK);
	    }

	   
	    @PutMapping("/{id}")
	    public ResponseEntity<Order> updateOrder(@PathVariable Long id, @RequestBody Order updatedOrder) {
	        Order updated = orderService.updateOrder(id, updatedOrder);
	        return new ResponseEntity<>(updated, HttpStatus.OK);
	    }

	  
	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
	        orderService.deleteOrder(id);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	}