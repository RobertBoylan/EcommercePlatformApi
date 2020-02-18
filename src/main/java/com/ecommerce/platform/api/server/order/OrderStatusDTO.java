package com.ecommerce.platform.api.server.order;

import java.time.Duration;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderStatusDTO {

	@JsonProperty
	private long id;
	@JsonProperty
	private String status;
	@JsonProperty
	private Duration totalOrderTime;
	
	public OrderStatusDTO(Order order) {
		this.id = order.getID();
		this.status = order.getStatus();
		this.totalOrderTime = order.getTotalOrderTime();
	}
	
	public String getStatus() {
		return status;
	}
}
