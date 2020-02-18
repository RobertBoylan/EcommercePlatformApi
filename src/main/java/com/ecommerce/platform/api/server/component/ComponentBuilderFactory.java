package com.ecommerce.platform.api.server.component;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ecommerce.platform.api.server.builder.BuilderPopulator.Attribute;
import com.ecommerce.platform.api.server.component.input_output.InputComponentBuilder;
import com.ecommerce.platform.api.server.component.input_output.OutputComponentBuilder;
import com.ecommerce.platform.api.server.component.memory.MemoryComponentBuilder;
import com.ecommerce.platform.api.server.component.processing.ProcessingComponentBuilder;
import com.ecommerce.platform.api.server.component.storage.StorageComponentBuilder;

public class ComponentBuilderFactory {

	private static final Logger logger = LogManager.getLogger(ComponentBuilderFactory.class);

	private ComponentBuilderFactory() {
		throw new IllegalStateException("Static class");
	}

	public static IComponentBuilder getComponent(String componentString) {
		String category = componentString.split(",")[Attribute.CATEGORY.ordinal()].trim();

		if(category.equalsIgnoreCase("CPU") || category.equalsIgnoreCase("GPU")){
			return new ProcessingComponentBuilder();
		}
		else if(category.equalsIgnoreCase("Keyboard") || category.equalsIgnoreCase("Mouse")) {
			return new InputComponentBuilder();
		}
		else if(category.equalsIgnoreCase("Monitor")) {
			return new OutputComponentBuilder();
		}
		else if(category.equalsIgnoreCase("Memory")){
			return new MemoryComponentBuilder();
		}
		else if(category.equalsIgnoreCase("Storage")){
			return new StorageComponentBuilder();
		}

		logger.error("Unknown Component Type");

		throw new IllegalArgumentException();
	}
}
