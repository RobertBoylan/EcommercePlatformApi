package com.ecommerce.platform.api.server.order;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class OrderStatusTest {

	@Test
    public void testOrderReceived() {	
    	assertEquals("Order Received", OrderStatus.ORDER_RECEIVED);
	}
	
	@Test
    public void testOrderInProgress() {
    	assertEquals("Order In-Progress", OrderStatus.ORDER_IN_PROGRESS);
	}
	
	@Test
    public void testOrderReady() {	
    	assertEquals("Order Ready", OrderStatus.ORDER_READY);
	}
	
	@Test
    public void testOrderRejected() {	
    	assertEquals("Order Rejected", OrderStatus.ORDER_REJECTED);
	}
	
	@Test
    public void testOrderCancelled() {
    	assertEquals("Order Cancelled", OrderStatus.ORDER_CANCELLED);
	}
}
