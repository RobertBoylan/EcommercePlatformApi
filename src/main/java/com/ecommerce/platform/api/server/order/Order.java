package com.ecommerce.platform.api.server.order;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.Valid;

import com.ecommerce.platform.api.server.component.ComponentSpecs;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Entity
@Table(name = "ORDERS")
@JsonPropertyOrder({ "id", "status", "createdDateTime", "lastUpdatedDateTime", "totalOrderTime", "components"})
public class Order {
	
	@Id
	@JsonProperty
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	@JsonIgnore
	private String status;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private LocalDateTime createdDateTime;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private LocalDateTime lastUpdatedDateTime;
	@Transient
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Duration totalOrderTime;
	@JsonIgnore
	@Transient
	private List<UUID> componentIDs;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
            name = "Order_Component",
            joinColumns = { @JoinColumn(name = "order_id", referencedColumnName = "id") },
            inverseJoinColumns = { @JoinColumn(name = "component_id", referencedColumnName = "id") }
    )
	@Valid
    private List<ComponentSpecs> components = new ArrayList<>();
	
    public void setComponentIDs(List<UUID> componentIDs) {
		this.componentIDs = componentIDs;
	}
    
    public void setCreatedDateTime(LocalDateTime createdDateTime) {
		this.createdDateTime = createdDateTime;
	}
	
	public void setLastUpdatedDateTime(LocalDateTime lastUpdatedDateTime) {
		this.lastUpdatedDateTime = lastUpdatedDateTime;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public void setTotalOrderTime(Duration totalOrderTime) {
		this.totalOrderTime = totalOrderTime;
	}
	
	public void setComponents(List<ComponentSpecs> components) {
		this.components = components;
    }
	
	public long getID() {
		return id;
	}
	
	public List<UUID> getComponentIDs() {
		return componentIDs;
	}
	
	public List<ComponentSpecs> getComponents() {
        return components;
    }
	
	public String getStatus() {
        return status;
    }
	
	public Duration getTotalOrderTime() {
		if(status.equals(OrderStatus.ORDER_RECEIVED) || status.equals(OrderStatus.ORDER_IN_PROGRESS) ) {
			totalOrderTime = Duration.between(createdDateTime, LocalDateTime.now());
		}
		
        return totalOrderTime;
    }
	
	public void addComponent(ComponentSpecs component) {
		List<ComponentSpecs> tempComponentList = new ArrayList<>(components);
		tempComponentList.add(component);
		components = tempComponentList;
		component.getOrders().add(this);
    }
}
