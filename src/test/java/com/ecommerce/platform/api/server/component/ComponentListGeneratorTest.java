package com.ecommerce.platform.api.server.component;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.ecommerce.platform.api.server.component.ComponentListGenerator;
import com.ecommerce.platform.api.server.component.ComponentSpecs;

class ComponentListGeneratorTest {
	private static final String FILE_NAME = "Inventory.csv";

	@Test
	void testGenerateComponentListNotNull() throws IOException, URISyntaxException {	
		List<ComponentSpecs> componentList = ComponentListGenerator.generateComponentList(FILE_NAME);
		
		assertNotNull(componentList);
	}
	
	@Test
	void testGenerateComponentListNullPointerException() throws IOException, URISyntaxException {
		assertThrows(NullPointerException.class, () -> {
			ComponentListGenerator.generateComponentList("test.csv");
		});
	}
}
