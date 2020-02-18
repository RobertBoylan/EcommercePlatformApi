package com.ecommerce.platform.api.server.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.platform.api.server.component.ComponentSpecs;
import com.ecommerce.platform.api.server.dao.IDAO;

@Service
public class ComponentService implements IComponentService {

	private IDAO componentDAO;
	
	@Autowired
	public ComponentService(IDAO componentDAO) {	
		this.componentDAO = componentDAO;
	}

	@Override
	public long count() {		
		return componentDAO.count();
	}

	@Override
	public List<ComponentSpecs> findByName(String name) {		
		return componentDAO.findByName(name);
	}
	
	@Override
	public ComponentSpecs findByID(UUID id) {		
		return componentDAO.findByid(id);
	}
	
	@Override
	public List<ComponentSpecs> findAll() {		
		return componentDAO.findAll();
	}
	
	@Override
	public void save(ComponentSpecs component) {		
		componentDAO.save(component);
	}
	
	@Override
	public void saveAll(List<ComponentSpecs> components) {		
		componentDAO.saveAll(components);
	}
}
