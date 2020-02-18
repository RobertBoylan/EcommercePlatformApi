package com.ecommerce.platform.api.server.component;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.ecommerce.platform.api.server.component.ComponentBuilderFactory;
import com.ecommerce.platform.api.server.component.input_output.InputComponentBuilder;
import com.ecommerce.platform.api.server.component.input_output.OutputComponentBuilder;
import com.ecommerce.platform.api.server.component.memory.MemoryComponentBuilder;
import com.ecommerce.platform.api.server.component.processing.ProcessingComponentBuilder;
import com.ecommerce.platform.api.server.component.storage.StorageComponentBuilder;

@TestInstance(Lifecycle.PER_CLASS)
public class ComponentBuilderFactoryTest {
	
	@Test
	public void testGetComponentThrowsIllegalArgumentException() {
		assertThrows(IllegalArgumentException.class, () -> {
			ComponentBuilderFactory.getComponent("N/A,test,N/A,N/A,N/A,N/A,N/A,N/A,N/A,N/A,N/A,N/A,N/A,150,25");
		  });
	}
	
	@Test
	public void testGetComponentProcessing1() {
		assertEquals(ProcessingComponentBuilder.class, ComponentBuilderFactory.getComponent("N/A,CPU,N/A,N/A,N/A,N/A,N/A,N/A,N/A,N/A,N/A,N/A,N/A,150,25").getClass());
	}
	
	@Test
	public void testGetComponentProcessing2() {
		assertEquals(ProcessingComponentBuilder.class, ComponentBuilderFactory.getComponent("N/A,GPU,N/A,N/A,N/A,N/A,N/A,N/A,N/A,N/A,N/A,N/A,N/A,150,25").getClass());
	}
	
	@Test
	public void testGetComponentInput1() {
		assertEquals(InputComponentBuilder.class, ComponentBuilderFactory.getComponent("N/A,Keyboard,N/A,N/A,N/A,N/A,N/A,N/A,N/A,N/A,N/A,N/A,N/A,150,25").getClass());
	}
	
	@Test
	public void testGetComponentInput2() {
		assertEquals(InputComponentBuilder.class, ComponentBuilderFactory.getComponent("N/A,Mouse,N/A,N/A,N/A,N/A,N/A,N/A,N/A,N/A,N/A,N/A,N/A,150,25").getClass());
	}
	
	@Test
	public void testGetComponentOutput() {
		assertEquals(OutputComponentBuilder.class, ComponentBuilderFactory.getComponent("N/A,Monitor,N/A,N/A,N/A,N/A,N/A,N/A,N/A,N/A,N/A,N/A,N/A,150,25").getClass());
	}
	
	@Test
	public void testGetComponentMemory() {
		assertEquals(MemoryComponentBuilder.class, ComponentBuilderFactory.getComponent("N/A,Memory,N/A,N/A,N/A,N/A,N/A,N/A,N/A,N/A,N/A,N/A,N/A,150,25").getClass());
	}
	
	@Test
	public void testGetComponentStorage() {
		assertEquals(StorageComponentBuilder.class, ComponentBuilderFactory.getComponent("N/A,Storage,N/A,N/A,N/A,N/A,N/A,N/A,N/A,N/A,N/A,N/A,N/A,150,25").getClass());
	}
}
