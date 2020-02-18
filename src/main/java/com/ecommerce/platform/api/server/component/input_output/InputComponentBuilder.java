package com.ecommerce.platform.api.server.component.input_output;

import com.ecommerce.platform.api.server.builder.BuilderPopulator;
import com.ecommerce.platform.api.server.component.IComponentBuilder;

public class InputComponentBuilder implements IComponentBuilder {
	@Override
	public InputComponentSpecs buildComponent(String componentString) {
		return new InputComponentSpecs(BuilderPopulator.populateBuilder(componentString));
	}
}
