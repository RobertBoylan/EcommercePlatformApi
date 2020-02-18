package com.ecommerce.platform.api.server.component.storage;

import com.ecommerce.platform.api.server.builder.BuilderPopulator;
import com.ecommerce.platform.api.server.component.IComponentBuilder;

public class StorageComponentBuilder implements IComponentBuilder {
	@Override
	public StorageComponentSpecs buildComponent(String componentString) {	
		return new StorageComponentSpecs(BuilderPopulator.populateBuilder(componentString));
	}
}
