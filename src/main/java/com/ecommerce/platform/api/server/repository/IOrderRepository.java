package com.ecommerce.platform.api.server.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.platform.api.server.order.Order;

@Repository
public interface IOrderRepository extends CrudRepository<Order, Long> {
	Order findByid(UUID id);
}
