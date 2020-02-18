package com.ecommerce.platform.api.server.component.storage;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.ecommerce.platform.api.server.builder.Builder;
import com.ecommerce.platform.api.server.component.ComponentSpecs;

@Entity
@Table(name = "Storage")
public class StorageComponentSpecs extends ComponentSpecs {

	private String size;
	private String interfaceType;
	
	public StorageComponentSpecs(Builder builder) {
		super(builder);
		this.size = builder.getSize();
		this.interfaceType = builder.getInterfaceType();
	}
	
	public StorageComponentSpecs(){
		super();
	}
	
	public String getSize() {
		return size;
	}
	
	public String getInterfaceType() {
		return interfaceType;
	}
}
