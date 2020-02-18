package com.ecommerce.platform.api.server.repository;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ecommerce.platform.api.server.component.ComponentListGenerator;
import com.ecommerce.platform.api.server.dao.IDAO;

@Component
public class ComponentRepositorySetup implements InitializingBean {

	private static final String INVENTORY_FILE_NAME = "Inventory.csv";
		
	@Autowired
	private IDAO componentDAO;

	@Override
	public void afterPropertiesSet() throws Exception {	  
		componentDAO.saveAll(ComponentListGenerator.generateComponentList(INVENTORY_FILE_NAME));
	}
}
