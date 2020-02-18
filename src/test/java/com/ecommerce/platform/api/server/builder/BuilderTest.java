package com.ecommerce.platform.api.server.builder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.UUID;

import org.junit.jupiter.api.Test;

import com.ecommerce.platform.api.server.builder.Builder;

public class BuilderTest {
	
	@Test
    public void testBuilderNotNull() {
		Builder builder = new Builder();
			
    	assertNotNull(builder);
	}
	
	@Test
    public void testBuilderSetFields1() {
		Builder builder = new Builder();
		
		UUID testUUID = UUID.randomUUID();
		
    	builder.id(testUUID);
    	
    	assertEquals(testUUID, builder.getID());
    	assertNull(builder.getBrand());
    	assertNull(builder.getDimension());
    	assertEquals(0, builder.getQuantity());
	}
	
	@Test
    public void testBuilderSetFields2() {
		Builder builder = new Builder();
		
    	builder.category("CPU");
    	builder.name("Xeon Processor E7-8893");
    	builder.brand("Intel");
    	builder.productLine("Xeon");
    	builder.numberOfCores(4);

    	assertEquals("CPU", builder.getCategory());
    	assertEquals("Xeon Processor E7-8893", builder.getName());
    	assertEquals("Intel", builder.getBrand());
    	assertEquals("Xeon", builder.getProductLine());
    	assertEquals(4, builder.getNumberOfCores());
    	assertNull(builder.getInterfaceType());
    	assertNull(builder.getGraphicsClockSpeed());
    	assertEquals(0, builder.getPrice());
	}
	
	@Test
    public void testBuilderSetFields3() {
		Builder builder = new Builder();
		
    	builder.category("CPU");
    	builder.name("Xeon Processor E7-8893");
    	builder.brand("Intel");
    	builder.productLine("Xeon");
    	builder.numberOfCores(4);
    	builder.price(45);
    	builder.quantity(100);

    	assertEquals("CPU", builder.getCategory());
    	assertEquals("Xeon Processor E7-8893", builder.getName());
    	assertEquals("Intel", builder.getBrand());
    	assertEquals("Xeon", builder.getProductLine());
    	assertEquals(4, builder.getNumberOfCores());
    	assertNull(builder.getInterfaceType());
    	assertNull(builder.getGraphicsClockSpeed());
    	assertEquals(45, builder.getPrice());
    	assertEquals(100, builder.getQuantity());
	}
}
