package com.ecommerce.platform.api.server.component.input_output;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.ecommerce.platform.api.server.builder.Builder;
  
@Entity
@Table(name = "Output")
public class OutputComponentSpecs extends InputOutputComponentSpecs {
	
	private String resolution;
	
	public OutputComponentSpecs(Builder builder) {
		super(builder);
		this.resolution = builder.getResolution();
	}
	
	public OutputComponentSpecs(){
		super();
	}
	
	public String getResolution() {
		return resolution;
	}
}
