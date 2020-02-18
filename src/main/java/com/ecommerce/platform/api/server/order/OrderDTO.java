package com.ecommerce.platform.api.server.order;

import java.util.List;
import java.util.UUID;

public class OrderDTO {

	private UUID id;
	private List<UUID> componentIDs;
	
	public List<UUID> getComponentIDs() {
		return componentIDs;
	}
	
	public void setComponentIDs(List<UUID> componentIDs) {
		this.componentIDs = componentIDs;
	}
	
	public UUID getID() {
		return id;
	}
	
	public void setID(UUID id) {
		this.id = id;
	}
}
