package com.ecommerce.platform.api.server.order;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class OrderQueue {

	private BlockingQueue<Order> queue;
	
	public OrderQueue() {
		queue = new LinkedBlockingDeque<>();
	}
	
	public void push(Order order) throws InterruptedException {
		queue.put(order);
	}
	
	public Order pop() throws InterruptedException {
		return queue.take();
	}
	
	public int size() {
		return queue.size();
	}
	
	public boolean isEmpty() {
		return queue.isEmpty();
	}
	
	public BlockingQueue<Order> getQueue() {
		return queue;
	}
}
