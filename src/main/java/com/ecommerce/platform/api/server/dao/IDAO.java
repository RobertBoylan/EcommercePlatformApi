package com.ecommerce.platform.api.server.dao;

import java.util.List;
import java.util.UUID;

import com.ecommerce.platform.api.server.component.ComponentSpecs;

public interface IDAO {
	void saveAll(List<ComponentSpecs> componentList);
	void save(ComponentSpecs component);
	Long count();
	List<ComponentSpecs> findByName(String name);	
	ComponentSpecs findByid(UUID id);
	List<ComponentSpecs> findAll();
	void tearDown();
}
