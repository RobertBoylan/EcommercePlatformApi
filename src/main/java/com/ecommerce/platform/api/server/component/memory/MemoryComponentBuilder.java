package com.ecommerce.platform.api.server.component.memory;

import com.ecommerce.platform.api.server.builder.BuilderPopulator;
import com.ecommerce.platform.api.server.component.IComponentBuilder;

public class MemoryComponentBuilder implements IComponentBuilder {
	@Override
	public MemoryComponentSpecs buildComponent(String componentString) {		
		return new MemoryComponentSpecs(BuilderPopulator.populateBuilder(componentString));
	}
}
