package com.ecommerce.platform.api.server.order;

import java.time.LocalDateTime;
import java.util.Collections;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ecommerce.platform.api.server.repository.IOrderRepository;
import com.ecommerce.platform.api.server.service.ComponentService;

public class OrderState {
	
	private static final Logger logger = LogManager.getLogger(OrderState.class);
	private IOrderRepository orderRepository;
	private OrderProcess orderProcess; 

	public OrderState(IOrderRepository orderRepository) {	
		this.orderRepository = orderRepository;
		
		orderProcess = new OrderProcess(orderRepository);
	}

	public boolean orderReceived(Order order, ComponentService componentService) {  
		logger.info("Order Received");
		
		if(orderProcess.checkQuantity(order, componentService)) {
			orderRejected(order);	
			orderRepository.save(order);
	    	
	    	return true;
		}  	
    	return false;
	}
	
	public Order orderInProgress(Order order) {
		logger.info("Order In-Progress");
		
		order.setStatus(OrderStatus.ORDER_IN_PROGRESS); 	
    	order.setLastUpdatedDateTime(LocalDateTime.now()); 
    	
    	orderRepository.save(order);
    	
    	return order;
	}
	
	public Order orderReady(Order order, ComponentService componentService) {
		logger.info("Order Ready");
		
		order.setStatus(OrderStatus.ORDER_READY);    	
    	order.setLastUpdatedDateTime(LocalDateTime.now());   	 	
    	orderProcess.process(order, componentService);
    	
    	orderRepository.save(order);
    	
    	return order;
	}

	public Order orderRejected(Order order) {
		logger.info("Rejecting Order");
		
		order.setStatus(OrderStatus.ORDER_REJECTED);   	
    	order.setLastUpdatedDateTime(LocalDateTime.now());    	
    	order.setComponents(Collections.emptyList());
    	
    	orderRepository.save(order);
    	
    	return order;
	}

	public Order orderCancelled(Order order) {
		logger.info("Cancelling Order");
		
		order.setStatus(OrderStatus.ORDER_CANCELLED);
    	order.setLastUpdatedDateTime(LocalDateTime.now());
    	order.setComponents(Collections.emptyList());
    	
    	orderRepository.save(order);
    	
    	return order;
	}
}
