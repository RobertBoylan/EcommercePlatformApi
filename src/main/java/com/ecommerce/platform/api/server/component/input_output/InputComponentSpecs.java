package com.ecommerce.platform.api.server.component.input_output;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.ecommerce.platform.api.server.builder.Builder;

@Entity
@Table(name = "Input")
public class InputComponentSpecs extends InputOutputComponentSpecs {
	
	public InputComponentSpecs(Builder builder) {
		super(builder);
	}
	
	public InputComponentSpecs(){
		super();
	}
}
