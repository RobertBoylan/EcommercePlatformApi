package com.ecommerce.platform.api.server.order;

import com.ecommerce.platform.api.server.service.ComponentService;

public class OrderAssembler {

	private static final int ORDER_BUILD_TIME = 10;

	private OrderAssembler() {
		throw new IllegalStateException("Static class");
	}

	public static Order assemble(Order order, OrderState orderState, ComponentService componentService) throws InterruptedException {	
		orderState.orderInProgress(order);

		for(int i=0; i<ORDER_BUILD_TIME*10; ++i) {       		
			if(order.getStatus().equals(OrderStatus.ORDER_CANCELLED)) {   
				throw new InterruptedException();
			}	
			OrderUtilities.sleep(100);   
		}

		orderState.orderReady(order, componentService);

		return order;
	}
}
