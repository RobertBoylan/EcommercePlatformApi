package com.ecommerce.platform.api.server.component.processing;

import com.ecommerce.platform.api.server.builder.BuilderPopulator;
import com.ecommerce.platform.api.server.component.ComponentSpecs;
import com.ecommerce.platform.api.server.component.IComponentBuilder;

public class ProcessingComponentBuilder implements IComponentBuilder {
	@Override
	public ComponentSpecs buildComponent(String componentString) {			
		return new ProcessingComponentSpecs(BuilderPopulator.populateBuilder(componentString));
	}
}
