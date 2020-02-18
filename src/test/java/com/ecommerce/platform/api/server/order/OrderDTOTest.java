package com.ecommerce.platform.api.server.order;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class OrderDTOTest {

	@Test
    public void testOrderDTONotNull() {
    	assertNotNull(new OrderDTO());
	}
}
