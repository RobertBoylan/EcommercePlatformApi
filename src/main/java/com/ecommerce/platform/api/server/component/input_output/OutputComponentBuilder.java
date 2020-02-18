package com.ecommerce.platform.api.server.component.input_output;

import com.ecommerce.platform.api.server.builder.BuilderPopulator;
import com.ecommerce.platform.api.server.component.IComponentBuilder;

public class OutputComponentBuilder implements IComponentBuilder {
	@Override
	public OutputComponentSpecs buildComponent(String componentString) {
		return new OutputComponentSpecs(BuilderPopulator.populateBuilder(componentString));
	}
}