package com.ecommerce.platform.api.server.inmemory_warehouse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ecommerce.platform.api.server.component.ComponentSpecs;
import com.ecommerce.platform.api.server.dao.IDAO;

public class InMemoryWarehouseAccess implements IDAO {

	private static final Logger logger = LogManager.getLogger(InMemoryWarehouseAccess.class);
	private Map<String, List<ComponentSpecs>> inMemoryWarehouse;
	
	public InMemoryWarehouseAccess() {
		inMemoryWarehouse = new HashMap<>();
	}
	
	@Override
	public synchronized void saveAll(List<ComponentSpecs> componentList) {
		logger.info("Saving Components");
		
		for(ComponentSpecs component : componentList) {
			if(inMemoryWarehouse.containsKey(component.getName().toUpperCase())) {	
				List<ComponentSpecs> tempList = inMemoryWarehouse.get(component.getName().toUpperCase());	
				tempList.add(component);				
				inMemoryWarehouse.replace(component.getName().toUpperCase(), tempList);
			}
			else {
				List<ComponentSpecs> tempList = new ArrayList<>();
				tempList.add(component);		
				inMemoryWarehouse.put(component.getName().toUpperCase(), tempList);
			}
		}
	}
	
	@Override
	public synchronized void save(ComponentSpecs component) {
		logger.info("Saving Component");
			
		if(inMemoryWarehouse.containsKey(component.getName().toUpperCase())) {
			List<ComponentSpecs> tempList = inMemoryWarehouse.get(component.getName().toUpperCase());
			tempList.add(component);
			inMemoryWarehouse.replace(component.getName().toUpperCase(), tempList);
		}
		else {
			List<ComponentSpecs> tempList = new ArrayList<>();
			tempList.add(component);
			inMemoryWarehouse.put(component.getName().toUpperCase(), tempList);
		}
	}
	
	@Override
	public synchronized List<ComponentSpecs> findAll() {		
		logger.info("Attempting to find all components");
		
		List<ComponentSpecs> componentSpecsList = new ArrayList<>();
				
		for(Entry<String, List<ComponentSpecs>> entry: inMemoryWarehouse.entrySet()) {
			for(ComponentSpecs componentSpecs : entry.getValue()) {	
				componentSpecsList.add(componentSpecs);
			}
		}

		return componentSpecsList;
	}
	
	@Override
	public synchronized Long count() {
		return (long) findAll().size();
	}

	@Override
	public synchronized List<ComponentSpecs> findByName(String name) {	
		logger.info("Attempting to find: {}", name);
		
		List<ComponentSpecs> componentSpecsList = new ArrayList<>();
		
		for(Map.Entry<String,List<ComponentSpecs>> entry : inMemoryWarehouse.entrySet()) {			
			if(entry.getKey().contains(name)) {			
				for(ComponentSpecs componentSpecs: entry.getValue()) {				
					componentSpecsList.add(componentSpecs);
				}
			}
		}
	
		return componentSpecsList;
	}
	
	@Override
	public synchronized ComponentSpecs findByid(UUID id) {		
		logger.info("Attempting to find: {}", id);
		
		for(Map.Entry<String,List<ComponentSpecs>> entry : inMemoryWarehouse.entrySet()) {			
			for(ComponentSpecs component : entry.getValue()) {				
				if(component.getID().compareTo(id) == 0) {					
					return component;
				}
			}
		}
		logger.error("{} was not found.", id);
		
		return null;
	}
	
	@Override
	public synchronized void tearDown( ) {
		logger.info("Attempting to delete contents of the In-Memory Warehouse");
		
		inMemoryWarehouse = Collections.emptyMap();
	}
}
