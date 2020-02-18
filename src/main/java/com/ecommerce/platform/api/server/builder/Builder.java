package com.ecommerce.platform.api.server.builder;

import java.util.UUID;

public class Builder {
	private UUID id;
	private String category;
	private String name;
	private String brand;
	private String productLine;
	private int numberOfCores;
	private String processorClockSpeed;
	private String graphicsClockSpeed;
	private String dimension;
	private String resolution;
	private String colour;
	private String interfaceType;
	private String size;
	private int price;
	private int quantity;
	
	public Builder id(UUID id) {
		this.id = id;
		return this;
	}
	
	public Builder category(String category) {
		this.category = category;
		return this;
	}
	
	public Builder name(String name) {
		this.name = name;
		return this;
	}
	
	public Builder brand(String brand) {
		this.brand = brand;
		return this;
	}
	
	public Builder productLine(String productLine) {
		this.productLine = productLine;
		return this;
	}
	
	public Builder numberOfCores(int numberOfCores) {
		this.numberOfCores = numberOfCores;
		return this;
	}
	
	public Builder processorClockSpeed(String processorClockSpeed) {
		this.processorClockSpeed = processorClockSpeed;
		return this;
	}
	
	public Builder graphicsClockSpeed(String graphicsClockSpeed) {
		this.graphicsClockSpeed = graphicsClockSpeed;
		return this;
	}
	
	public Builder dimension(String dimension) {
		this.dimension = dimension;
		return this;
	}
	
	public Builder resolution(String resolution) {
		this.resolution = resolution;
		return this;
	}
	
	public Builder colour(String colour) {
		this.colour = colour;
		return this;
	}
	
	public Builder interfaceType(String interfaceType) {
		this.interfaceType = interfaceType;
		return this;
	}
	
	public Builder size(String size) {
		this.size = size;
		return this;
	}
	
	public Builder price(int price) {
		this.price = price;
		return this;
	}
	
	public Builder quantity(int quantity) {
		this.quantity = quantity;
		return this;
	}
	
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
	
	public String getProductLine() {
		return productLine;
	}
	
	public int getNumberOfCores() {
		return numberOfCores;
	}
	
	public String getProcessorClockSpeed() {
		return processorClockSpeed;
	}
	
	public String getGraphicsClockSpeed() {
		return graphicsClockSpeed;
	}
	
	public String getDimension() {
		return dimension;
	}
	
	public String getResolution() {
		return resolution;
	}
	
	public String getColour() {
		return colour;
	}
	
	public String getInterfaceType() {
		return interfaceType;
	}
	
	public String getSize() {
		return size;
	}
	
	public int getPrice() {
		return price;
	}
	
	public int getQuantity() {
		return quantity;
	}
}
