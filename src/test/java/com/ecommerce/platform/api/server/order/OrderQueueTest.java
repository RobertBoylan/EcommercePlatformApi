package com.ecommerce.platform.api.server.order;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;

@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderQueueTest {

	private static final Logger logger = LogManager.getLogger(OrderQueueTest.class);
	
	private OrderQueue queue;
	
	@BeforeAll
    public void initializeTestData() {
			
		queue = new OrderQueue();
	}
	
	@Test
	@Order(1)
    public void testOrderQueueNotNull() {
			
    	assertNotNull(queue);
	}
	
	@Test
	@Order(2)
    public void testOrderQueueSize() {
		
    	assertEquals(0, queue.size());
	}
	
	@Test
	@Order(3)
    public void testOrderQueuePush() throws InterruptedException {
		
		try {
			queue.push(new com.ecommerce.platform.api.server.order.Order());
		} catch (InterruptedException e) {
			logger.error("Exception thrown when adding order to the queue: {}", e);	
			Thread.currentThread().interrupt();
		}
		
    	assertEquals(1, queue.size());
	}
	
	@Test
	@Order(4)
    public void testOrderQueuePop() throws InterruptedException {
		
		try {
			queue.pop();
		} catch (InterruptedException e) {
			logger.error("Exception thrown when adding order to the queue: {}", e);	
			Thread.currentThread().interrupt();
		}
		
    	assertEquals(0, queue.size());
	}
	
	@Test
	@Order(5)
    public void testOrderQueueIsEmpty() {
		
    	assertEquals(true, queue.isEmpty());
	}
	
	@Test
	@Order(6)
    public void testOrderQueueIsNotEmpty() throws InterruptedException {
		
		try {
			queue.push(new com.ecommerce.platform.api.server.order.Order());
		} catch (InterruptedException e) {
			logger.error("Exception thrown when adding order to the queue: {}", e);	
			Thread.currentThread().interrupt();
		}
		
    	assertEquals(false, queue.isEmpty());
	}
}
