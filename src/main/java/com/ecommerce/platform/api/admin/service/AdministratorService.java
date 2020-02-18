package com.ecommerce.platform.api.admin.service;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.platform.api.admin.Administrator;
import com.ecommerce.platform.api.server.service.OrderService;

import reactor.core.publisher.Flux;

@Service
public class AdministratorService implements IAdministratorService {
	private static final long MEGABYTE = 1024L * 1024L;

	private OrderService orderService;

	@Autowired
	private void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	
	@Override
	public Flux<Administrator> getAdministrator() {
		return Flux.interval(Duration.ofMillis(500))
				.map(sequence -> new Administrator(orderService.getNumberOfConnectedClients(), 
												   orderService.getNumberOfOrdersInAssemblers(), 
												   orderService.getNumberOfWaitingClients(), 
												   calculateMemoryUsageInMB()));
	}
	
	private long calculateMemoryUsageInMB() {
		Runtime runtime = Runtime.getRuntime();
		runtime.gc();

		return (runtime.totalMemory() - runtime.freeMemory()) / MEGABYTE;
	}
}
