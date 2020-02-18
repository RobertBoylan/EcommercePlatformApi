package com.ecommerce.platform.api.server.service;

import java.time.Duration;
import java.util.concurrent.ExecutionException;

import com.ecommerce.platform.api.server.order.OrderDTO;
import com.ecommerce.platform.api.server.order.OrderStatusDTO;

import reactor.core.publisher.Flux;

public interface IOrderService {

	Flux<OrderStatusDTO> create(OrderDTO orderDTO) throws InterruptedException, ExecutionException;
	int getNumberOfWaitingClients();
	int getNumberOfOrdersInAssemblers();
	int getNumberOfConnectedClients();
	Duration getTotalWaitTime();
	void setTotalWaitTime(Duration totalWaitTime);
	Duration getAverageWaitTime();
}
