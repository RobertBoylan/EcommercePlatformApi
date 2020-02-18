package com.ecommerce.platform.api.server.order;

import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ecommerce.platform.api.server.component.ComponentSpecs;
import com.ecommerce.platform.api.server.service.ComponentService;

public class OrderUtilities {

	private static final Logger logger = LogManager.getLogger(OrderUtilities.class);
	
	private OrderUtilities() {
	    throw new IllegalStateException("Utility class");
	}

	public static void sleep(int millis) {
		
		try {	
			Thread.sleep(millis);
		} catch (InterruptedException e) {		
			logger.info("Sleep thread was interrupted: {}", e);
			
			Thread.currentThread().interrupt();
		}
	}
    
	public static int getNewQuantity(ComponentSpecs component) {
    	return component.getQuantity()-1 > 0 ? component.getQuantity()-1 : component.getQuantity();
    }
    
	public static ComponentSpecs updateComponentQuantity(ComponentService componentService, UUID componentID) {	
		
		ComponentSpecs consumedComponent = componentService.findByID(componentID);
		
    	consumedComponent.setQuantity(consumedComponent.getQuantity()-1);
    	componentService.save(consumedComponent);
    	
    	return consumedComponent;
    } 
}
