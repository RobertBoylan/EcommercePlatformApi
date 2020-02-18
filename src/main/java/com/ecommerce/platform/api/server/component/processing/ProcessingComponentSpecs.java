package com.ecommerce.platform.api.server.component.processing;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.ecommerce.platform.api.server.builder.Builder;
import com.ecommerce.platform.api.server.component.ComponentSpecs;

@Entity
@Table(name = "ProcessingUnit")
public class ProcessingComponentSpecs extends ComponentSpecs {
	
	private String productLine;
	private int numberOfCores;
	private String processorClockSpeed;
	private String graphicsClockSpeed;
	
	public ProcessingComponentSpecs(Builder builder) {
		super(builder);
		this.productLine = builder.getProductLine();
		this.numberOfCores = builder.getNumberOfCores();
		this.processorClockSpeed = builder.getProcessorClockSpeed();
		this.graphicsClockSpeed = builder.getGraphicsClockSpeed();
	}
	
	public ProcessingComponentSpecs(){
		super();
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
}
