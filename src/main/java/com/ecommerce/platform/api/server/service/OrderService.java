package com.ecommerce.platform.api.server.service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.platform.api.server.order.Order;
import com.ecommerce.platform.api.server.order.OrderAssembler;
import com.ecommerce.platform.api.server.order.OrderDTO;
import com.ecommerce.platform.api.server.order.OrderQueue;
import com.ecommerce.platform.api.server.order.OrderState;
import com.ecommerce.platform.api.server.order.OrderStatus;
import com.ecommerce.platform.api.server.order.OrderStatusDTO;

import reactor.core.publisher.Flux;

@Service
public class OrderService implements IOrderService {

	private static final Logger logger = LogManager.getLogger(OrderService.class);

	private ComponentService componentService;
	private OrderQueue orderQueue;
	private OrderQueue assembledOrderQueue;
	private OrderState orderState;
	private Duration totalWaitTime;
	private int numberOfConnectedClients;
	private int numberOfOrdersInAssemblers;

	@Autowired
	public OrderService(OrderState orderState) {
		this.orderState = orderState;
		this.orderQueue = new OrderQueue();
		this.assembledOrderQueue = new OrderQueue();
		this.numberOfConnectedClients = 0;
		this.numberOfOrdersInAssemblers = 0;
	}

	@Autowired
	private void setComponentService(ComponentService componentService) {
		this.componentService = componentService;
	}

	@Override
	public Flux<OrderStatusDTO> create(OrderDTO orderDTO) throws InterruptedException, ExecutionException {
		ExecutorService executor = Executors.newFixedThreadPool(2);

		Order order = convertFromDTO(orderDTO);

		if(!orderState.orderReceived(order, componentService)) {
			return Flux.fromStream(Stream.generate(() -> new OrderStatusDTO(order))) 
					.doOnCancel(() -> {
						orderState.orderCancelled(order);
						numberOfConnectedClients--;
					}
				);
		}

		executor.execute(producerTask(order));
		executor.execute(consumerTask());

		executor.shutdown();

		return Flux.fromStream(Stream.generate(() -> new OrderStatusDTO(order)))
				.doOnCancel(() -> {
					if(!order.getStatus().equals(OrderStatus.ORDER_READY)) {
						orderState.orderCancelled(order);
					}
					numberOfConnectedClients--;
				}
			);
	}

	@Override
	public int getNumberOfConnectedClients() {   	
		return numberOfConnectedClients;
	}

	@Override
	public int getNumberOfOrdersInAssemblers() {   	
		return numberOfOrdersInAssemblers;
	}

	@Override
	public int getNumberOfWaitingClients() {   	
		return orderQueue.size();
	}

	@Override
	public Duration getTotalWaitTime() {   	
		return totalWaitTime;
	}

	@Override
	public void setTotalWaitTime(Duration totalWaitTime) {	    	
		this.totalWaitTime = totalWaitTime;
	}

	@Override
	public Duration getAverageWaitTime() {  	
		return totalWaitTime.dividedBy(assembledOrderQueue.size());
	}

	private Runnable producerTask(Order order) {
		return () -> {
			try {
				orderQueue.push(order);
			} catch (InterruptedException e) {
				logger.error("Exception thrown when adding order to the queue: {}", e);	
				
				Thread.currentThread().interrupt();
				return;
			}		
		};
	}

	private Runnable consumerTask() {
		return () -> {
			try {
				Order currentOrder = orderQueue.pop();

				if(currentOrder.getStatus().equals(OrderStatus.ORDER_CANCELLED)) {
					return;
				}

				Order assembledOrder = OrderAssembler.assemble(currentOrder, orderState, componentService);

				if(assembledOrder.getStatus().equals(OrderStatus.ORDER_CANCELLED)) {
					numberOfOrdersInAssemblers--;
					return;
				}

				assembledOrderQueue.push(assembledOrder);

				numberOfOrdersInAssemblers--;

				if(getTotalWaitTime() != null) {
					setTotalWaitTime(getTotalWaitTime().plus(assembledOrder.getTotalOrderTime()));
				} else {
					setTotalWaitTime(assembledOrder.getTotalOrderTime());
				}

				logger.info("Average wait time: {}", getAverageWaitTime());	
			} catch (InterruptedException e) {
				logger.error("Exception thrown when assembling order: {}", e);

				Thread.currentThread().interrupt();
				numberOfOrdersInAssemblers--;
				return;
			}
		};
	}

	private Order convertFromDTO(OrderDTO orderDTO) {    	
		Order order = new Order();

		order.setComponentIDs(orderDTO.getComponentIDs());   	
		order.setStatus(OrderStatus.ORDER_RECEIVED);    	
		order.setCreatedDateTime(LocalDateTime.now());   	
		order.setLastUpdatedDateTime(LocalDateTime.now());

		return order;
	}
}
