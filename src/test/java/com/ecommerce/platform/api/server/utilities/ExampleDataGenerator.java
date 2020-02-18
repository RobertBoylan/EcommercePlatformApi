package com.ecommerce.platform.api.server.utilities;

import java.util.UUID;

import com.ecommerce.platform.api.server.builder.Builder;
import com.ecommerce.platform.api.server.component.ComponentSpecs;
import com.ecommerce.platform.api.server.component.processing.ProcessingComponentSpecs;

public class ExampleDataGenerator {

	public static ComponentSpecs createExampleComputerComponentCPU() {
		Builder builder = new Builder();
		
		builder.id(UUID.fromString("00439eda-cb6c-47f5-ab25-6089434f493e"));
		builder.category("CPU");
    	builder.name("FX-6100");
    	builder.brand("AMD");
    	builder.productLine("AMD FX 6-Core Black Edition");
    	builder.numberOfCores(8);
    	builder.processorClockSpeed("3.9 GHz");
    	builder.price(45);
    	builder.quantity(100);
    	
    	return new ProcessingComponentSpecs(builder);
	}	
}
