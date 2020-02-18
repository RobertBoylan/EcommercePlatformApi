package com.ecommerce.platform.api.admin;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "connectedClients", "ordersInAssemblers", "waitingOrders", "memoryUsageInMB"})
public class Administrator {

	@JsonProperty
	private int connectedClients;
	@JsonProperty
	private int ordersInAssemblers;
	@JsonProperty
	private int waitingOrders;
	@JsonProperty
	private long memoryUsageInMB;
	
	public Administrator(int connectedClients, int ordersInAssemblers, int waitingOrders, long memoryUsageInMB) {
		this.connectedClients = connectedClients;
		this.ordersInAssemblers = ordersInAssemblers;
		this.waitingOrders = waitingOrders;
		this.memoryUsageInMB = memoryUsageInMB;
	}
	
	public int getConnectedClients() {
		return connectedClients;
	}

	public int getOrdersInAssemblers() {
		return ordersInAssemblers;
	}

	public int getWaitingOrders() {
		return waitingOrders;
	}

	public long getMemoryUsageInMB() {
		return memoryUsageInMB;
	}
}
