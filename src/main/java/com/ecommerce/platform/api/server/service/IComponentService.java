package com.ecommerce.platform.api.server.service;

import java.util.List;
import java.util.UUID;

import com.ecommerce.platform.api.server.component.ComponentSpecs;

public interface IComponentService {

	long count();
	List<ComponentSpecs> findByName(String name);
	ComponentSpecs findByID(UUID id);	
	List<ComponentSpecs> findAll();	
	void save(ComponentSpecs component);	
	void saveAll(List<ComponentSpecs> components);
}
