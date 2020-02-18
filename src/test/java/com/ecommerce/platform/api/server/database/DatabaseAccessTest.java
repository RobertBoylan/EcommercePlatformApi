package com.ecommerce.platform.api.server.database;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;

import com.ecommerce.platform.api.server.dao.IDAO;
import com.ecommerce.platform.api.server.database.DatabaseAccess;
import com.ecommerce.platform.api.server.repository.IComponentRepository;

@TestInstance(Lifecycle.PER_CLASS)
public class DatabaseAccessTest {
	
	@Autowired
	private IComponentRepository componentRepository;
	
	private IDAO dao;
	
	@BeforeAll
	void initialize() {
		dao = new DatabaseAccess(componentRepository);
	}
	
	@Test
	void testDAONotNull() {
		assertNotNull(dao);
	}
	
	@Test
	void testDAOType() {
		assertEquals("class com.ecommerce.platform.api.server.database.DatabaseAccess", dao.getClass().toString());
	}
}