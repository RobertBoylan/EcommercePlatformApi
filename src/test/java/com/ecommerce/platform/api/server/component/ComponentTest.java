package com.ecommerce.platform.api.server.component;

import static org.junit.jupiter.api.Assertions.*;

import java.util.UUID;

import org.junit.jupiter.api.Test;

import com.ecommerce.platform.api.server.builder.Builder;
import com.ecommerce.platform.api.server.component.input_output.InputComponentSpecs;
import com.ecommerce.platform.api.server.component.input_output.OutputComponentSpecs;
import com.ecommerce.platform.api.server.component.memory.MemoryComponentSpecs;
import com.ecommerce.platform.api.server.component.processing.ProcessingComponentSpecs;
import com.ecommerce.platform.api.server.component.storage.StorageComponentSpecs;

public class ComponentTest {
	
	@Test
    public void testComponentSpecsNotNull() {
		
		Builder builder = new Builder();

    	assertNotNull(new ProcessingComponentSpecs(builder));
	}
	
	@Test
    public void testStorageComponentSpecs() {
		
		Builder builder = new Builder();
    	
		UUID testUUID = UUID.randomUUID();
		
    	builder.id(testUUID);
    	builder.name("testName");
    	builder.price(0);
    	builder.interfaceType("SSD");
    	builder.size("1TB");
    	
    	StorageComponentSpecs componentSpecs = new StorageComponentSpecs(builder);
    	
    	assertEquals(testUUID, componentSpecs.getID());
    	assertEquals("testName", componentSpecs.getName());
    	assertEquals(0, componentSpecs.getPrice());
    	assertEquals("SSD", componentSpecs.getInterfaceType());
    	assertEquals("1TB", componentSpecs.getSize());
    	assertNull(componentSpecs.getCategory());
    	assertNull(componentSpecs.getBrand());
    	assertEquals(0, componentSpecs.getQuantity());
	}
	
	@Test
    public void testMemoryComponentSpecs() {
		
		Builder builder = new Builder();
    	
		UUID testUUID = UUID.randomUUID();
		
    	builder.id(testUUID);
    	builder.name("testName");
    	builder.price(0);
    	builder.interfaceType("DDR4");
    	builder.size("8GB");
    	
    	MemoryComponentSpecs componentSpecs = new MemoryComponentSpecs(builder);
    	
    	assertEquals(testUUID, componentSpecs.getID());
    	assertEquals("testName", componentSpecs.getName());
    	assertEquals(0, componentSpecs.getPrice());
    	assertEquals("DDR4", componentSpecs.getInterfaceType());
    	assertEquals("8GB", componentSpecs.getSize());
    	assertNull(componentSpecs.getCategory());
    	assertNull(componentSpecs.getBrand());
    	assertEquals(0, componentSpecs.getQuantity());
	}
	
	@Test
    public void testProcessingComponentSpecs() {
		Builder builder = new Builder();
    	
		UUID testUUID = UUID.randomUUID();
		
    	builder.id(testUUID);
    	builder.name("testName");
    	builder.price(0);
    	builder.numberOfCores(8);
    	builder.processorClockSpeed("3.10 GHz");
    	
    	ProcessingComponentSpecs componentSpecs = new ProcessingComponentSpecs(builder);
    	
    	assertEquals(testUUID, componentSpecs.getID());
    	assertEquals("testName", componentSpecs.getName());
    	assertEquals(0, componentSpecs.getPrice());
    	assertEquals(8, componentSpecs.getNumberOfCores());
    	assertEquals("3.10 GHz", componentSpecs.getProcessorClockSpeed());
    	assertNull(componentSpecs.getCategory());
    	assertNull(componentSpecs.getBrand());
    	assertNull(componentSpecs.getProductLine());
    	assertNull(componentSpecs.getGraphicsClockSpeed());
    	assertEquals(0, componentSpecs.getQuantity());
	}
	
	@Test
    public void testInputComponentSpecs() {
		Builder builder = new Builder();
    	
		UUID testUUID = UUID.randomUUID();
		
    	builder.id(testUUID);
    	builder.name("testName");
    	builder.price(0);
    	builder.colour("Black");
    	builder.dimension("31.5");
    	
    	InputComponentSpecs componentSpecs = new InputComponentSpecs(builder);
    	
    	assertEquals(testUUID, componentSpecs.getID());
    	assertEquals("testName", componentSpecs.getName());
    	assertEquals(0, componentSpecs.getPrice());
    	assertEquals("Black", componentSpecs.getColour());
    	assertEquals("31.5", componentSpecs.getDimensions());
    	assertNull(componentSpecs.getCategory());
    	assertNull(componentSpecs.getBrand());
    	assertEquals(0, componentSpecs.getQuantity());
	}
	
	@Test
    public void testOutputComponentSpecs() {
		Builder builder = new Builder();
    	
		UUID testUUID = UUID.randomUUID();
		
    	builder.id(testUUID);
    	builder.name("testName");
    	builder.price(0);
    	builder.colour("Red");
    	builder.resolution("1920 x 1080");
    	
    	OutputComponentSpecs componentSpecs = new OutputComponentSpecs(builder);
    	
    	assertEquals(testUUID, componentSpecs.getID());
    	assertEquals("testName", componentSpecs.getName());
    	assertEquals(0, componentSpecs.getPrice());
    	assertEquals("Red", componentSpecs.getColour());
    	assertEquals("1920 x 1080", componentSpecs.getResolution());
    	assertNull(componentSpecs.getCategory());
    	assertNull(componentSpecs.getBrand());
    	assertNull(componentSpecs.getDimensions());
    	assertEquals(0, componentSpecs.getQuantity());
	}
}
