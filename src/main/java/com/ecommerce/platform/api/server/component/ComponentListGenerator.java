package com.ecommerce.platform.api.server.component;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import com.ecommerce.platform.api.server.file_parse.FileParser;

public class ComponentListGenerator {
	
	private ComponentListGenerator() {
		throw new IllegalStateException("Static class");
	}
	
	public static List<ComponentSpecs> generateComponentList(String fileName) throws IOException, URISyntaxException {
		List<ComponentSpecs> componentSpecsList = new ArrayList<>();
    	List<String> componentStringList = FileParser.getListOfComponentStrings(fileName);
	   
    	for(String componentString : componentStringList) {
    		IComponentBuilder builder = ComponentBuilderFactory.getComponent(componentString);	
    		ComponentSpecs computerComponent = builder.buildComponent(componentString);		   
    		componentSpecsList.add(computerComponent);
    	}
    	
    	return componentSpecsList;
	}
}
