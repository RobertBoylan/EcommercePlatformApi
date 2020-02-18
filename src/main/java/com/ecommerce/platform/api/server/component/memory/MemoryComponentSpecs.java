package com.ecommerce.platform.api.server.component.memory;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.ecommerce.platform.api.server.builder.Builder;
import com.ecommerce.platform.api.server.component.ComponentSpecs;

@Entity
@Table(name = "Memory")
public class MemoryComponentSpecs extends ComponentSpecs {
	
	private String size;
	private String interfaceType;
	
	public MemoryComponentSpecs(Builder builder) {
		super(builder);
		this.size = builder.getSize();
		this.interfaceType = builder.getInterfaceType();
	}
	
	public MemoryComponentSpecs(){
		super();
	}
	
	public String getSize() {
		return size;
	}
	
	public String getInterfaceType() {
		return interfaceType;
	}
}