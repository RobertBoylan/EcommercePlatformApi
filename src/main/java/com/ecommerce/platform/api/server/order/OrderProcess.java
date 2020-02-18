package com.ecommerce.platform.api.server.order;

import java.util.UUID;

import com.ecommerce.platform.api.server.repository.IOrderRepository;
import com.ecommerce.platform.api.server.service.ComponentService;

public class OrderProcess {

	private IOrderRepository orderRepository;
	
	public OrderProcess(IOrderRepository orderRepository) {	
		this.orderRepository = orderRepository;
	}
	
	public Order process(Order order, ComponentService componentService) {
		for(UUID componentID : order.getComponentIDs()) {		
			order.addComponent(OrderUtilities.updateComponentQuantity(componentService, componentID));			
		}

		orderRepository.save(order);
		
		return order;
	}
	
	public boolean checkQuantity(Order order, ComponentService componentService) {
		for(UUID componentID : order.getComponentIDs()) {			
			if(componentService.findByID(componentID).getQuantity() <= 0) {							
				return false;
			}
		}	
		return true;
	}
}
