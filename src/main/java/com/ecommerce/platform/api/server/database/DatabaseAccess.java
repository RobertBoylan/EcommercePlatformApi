package com.ecommerce.platform.api.server.database;

import java.util.List;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ecommerce.platform.api.server.component.ComponentSpecs;
import com.ecommerce.platform.api.server.dao.IDAO;
import com.ecommerce.platform.api.server.repository.IComponentRepository;

public class DatabaseAccess implements IDAO {
	
	private static final Logger logger = LogManager.getLogger(DatabaseAccess.class);
	
	private final IComponentRepository componentRepository;
	
	public DatabaseAccess(IComponentRepository componentRepository) {
		this.componentRepository = componentRepository;
	}
		
	@Override
	public synchronized void saveAll(List<ComponentSpecs> componentList) {
		logger.info("Saving Components");
		
		componentRepository.saveAll(componentList);
	}
	
	@Override
	public synchronized void save(ComponentSpecs component) {
		logger.info("Saving component: {}", component.getID());
		
		componentRepository.save(component);
	}
	
	@Override
	public synchronized Long count() {
		logger.info("Number of components: {}", componentRepository.count());
		
		return componentRepository.count();
	}
	
	@Override
	public synchronized List<ComponentSpecs> findByName(String name) {
		logger.info("Attempting to find: {}", name);
		
		return componentRepository.findByNameContainingIgnoreCase(name);
	}
	
	@Override
	public synchronized ComponentSpecs findByid(UUID id) {
		logger.info("Attempting to find: {}", id);
		
		return componentRepository.findByid(id);
	}
	
	@Override
	public synchronized List<ComponentSpecs> findAll() {
		logger.info("Attempting to find all components");
		
		return (List<ComponentSpecs>) componentRepository.findAll();
	}
	
	@Override
	public synchronized void tearDown( ) {
		logger.info("Attempting to delete database contents");
		
		componentRepository.deleteAll();
	}
}
