package com.ecommerce.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.store.model.OrderItem;
import com.ecommerce.store.model.pk.OrderItemPK;

public interface OrderItemRepositoy extends JpaRepository<OrderItem, OrderItemPK> {

}
