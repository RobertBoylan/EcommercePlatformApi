package com.ecommerce.platform.api.server.component.input_output;

import javax.persistence.MappedSuperclass;

import com.ecommerce.platform.api.server.builder.Builder;
import com.ecommerce.platform.api.server.component.ComponentSpecs;

@MappedSuperclass
public abstract class InputOutputComponentSpecs extends ComponentSpecs {

	private String dimensions;
	private String colour;
	
	public InputOutputComponentSpecs(Builder builder) {
		super(builder);
		this.dimensions = builder.getDimension();
		this.colour = builder.getColour();
	}
	
	public InputOutputComponentSpecs(){
		super();
	}
	
	public String getDimensions() {
		return dimensions;
	}
	
	public String getColour() {
		return colour;
	}
}
