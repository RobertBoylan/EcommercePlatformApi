package com.ecommerce.platform.api.server.order;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import com.ecommerce.platform.api.server.order.OrderStatusDTO;

public class OrderStatusDTOTest {

	@Test
    public void testOrderStatusDTONotNull() {
		Order order = new Order();
		
		order.setStatus(OrderStatus.ORDER_RECEIVED);
		order.setCreatedDateTime(LocalDateTime.now());
		
    	assertNotNull(new OrderStatusDTO(order));
	}
}
