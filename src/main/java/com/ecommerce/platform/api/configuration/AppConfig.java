package com.ecommerce.platform.api.configuration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ecommerce.platform.api.admin.service.AdministratorService;
import com.ecommerce.platform.api.server.dao.IDAO;
import com.ecommerce.platform.api.server.database.DatabaseAccess;
import com.ecommerce.platform.api.server.inmemory_warehouse.InMemoryWarehouseAccess;
import com.ecommerce.platform.api.server.order.OrderState;
import com.ecommerce.platform.api.server.repository.IComponentRepository;
import com.ecommerce.platform.api.server.repository.IOrderRepository;
import com.ecommerce.platform.api.server.service.ComponentService;
import com.ecommerce.platform.api.server.service.OrderService;

@Configuration
public class AppConfig {

	private static final Logger logger = LogManager.getLogger(AppConfig.class);

	@Bean
    public ComponentService getComponentService(IDAO componentDAO) {
        return new ComponentService(componentDAO);
    }
	
	@Bean
    public OrderService getOrderService(OrderState orderState) {
        return new OrderService(orderState);
    }
	
	@Bean
    public AdministratorService getAdministratorService() {
        return new AdministratorService();
    }
	
	@Bean
    @ConditionalOnProperty(value="storage-mode", havingValue = "db", matchIfMissing = true)
    public IDAO getDatabaseDAO(IComponentRepository componentRepository) {
		
		logger.info("Using Database DAO");
		
        return new DatabaseAccess(componentRepository);
    }

    @Bean
    @ConditionalOnProperty(value="storage-mode", havingValue = "mem")
    public IDAO getInMemoryDAO() {
    	
    	logger.info("Using In Memory DAO");
    	
        return new InMemoryWarehouseAccess();
    }
    
    @Bean
    public OrderState getOrderState(IOrderRepository orderRepository) {
        return new OrderState(orderRepository);
    }
}
