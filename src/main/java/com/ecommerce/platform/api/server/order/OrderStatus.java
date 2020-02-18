package com.ecommerce.platform.api.server.order;

public class OrderStatus {
	
	private OrderStatus() {
	    throw new IllegalStateException("Utility class");
	}

	public static final String ORDER_RECEIVED = "Order Received";
	public static final String ORDER_IN_PROGRESS = "Order In-Progress";
	public static final String ORDER_READY = "Order Ready";
	public static final String ORDER_REJECTED = "Order Rejected";
	public static final String ORDER_CANCELLED = "Order Cancelled";
}
