package com.ecommerce.platform.api.server.component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.ecommerce.platform.api.server.builder.Builder;
import com.ecommerce.platform.api.server.order.Order;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "COMPONENT")
@JsonPropertyOrder({ "id", "category", "name", "brand"})
public abstract class ComponentSpecs {

	@Id
	@NotNull
	protected UUID id;
	@NotNull
	private String category;
	private String name;
	private String brand;
	private int price;
	private final AtomicInteger quantity = new AtomicInteger();
	
	@ManyToMany(mappedBy = "components", fetch = FetchType.EAGER)
	@JsonIgnore
    private List<Order> orders = new ArrayList<>();
	
	public ComponentSpecs(Builder builder) {
		this.id = builder.getID();
		this.category = builder.getCategory();
		this.name = builder.getName();
		this.brand = builder.getBrand(); 
		this.price = builder.getPrice();
		this.quantity.set(builder.getQuantity());
	}
	
	public ComponentSpecs() {}
	
	public UUID getID() {
		return id;
	}
	
	public String getCategory() {
		return category;
	}
	
	public String getName() {
		return name;
	}
	
	public String getBrand() {
		return brand;
	}
	
	public int getPrice() {
		return price;
	}
	
	@Access(AccessType.PROPERTY)
	@NotNull
	public int getQuantity() {
		return quantity.get();
	}
	
	public List<Order> getOrders() {
        return orders;
    }
	
	public void setQuantity(int newQuantity) {	
		while(true) {
            if(quantity.compareAndSet(getQuantity(), newQuantity)) {
                return;
            }
        }
	}
}
