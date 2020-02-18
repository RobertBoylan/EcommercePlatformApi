package com.ecommerce.platform.api.server.inmemory_warehouse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.ecommerce.platform.api.server.component.ComponentListGenerator;
import com.ecommerce.platform.api.server.component.ComponentSpecs;
import com.ecommerce.platform.api.server.inmemory_warehouse.InMemoryWarehouseAccess;

@TestInstance(Lifecycle.PER_CLASS)
public class InMemoryWarehouseAccessTest {

	private static final String TEST_FILE_NAME_1 = "EmptyInventory.csv";
	private static final String TEST_FILE_NAME_2 = "OneItemInventory.csv";
	private static final String TEST_FILE_NAME_3 = "SevenItemInventory.csv";
	
	private List<ComponentSpecs> emptyComponentSpecsList;
	private List<ComponentSpecs> oneComponentSpecsList;
	private List<ComponentSpecs> sevenComponentSpecsList;
	
	private InMemoryWarehouseAccess dao;
	
	@BeforeAll
	private void initializeTestData() throws IOException, URISyntaxException {
		emptyComponentSpecsList = ComponentListGenerator.generateComponentList(TEST_FILE_NAME_1);
		oneComponentSpecsList = ComponentListGenerator.generateComponentList(TEST_FILE_NAME_2);
		sevenComponentSpecsList = ComponentListGenerator.generateComponentList(TEST_FILE_NAME_3);
	}
	
	@BeforeEach
	private void initializeInMemoryWarehouseAccess() throws IOException, URISyntaxException {
		dao = new InMemoryWarehouseAccess();
	}
	
	@Test
	void testDAONotNull() {
		dao = new InMemoryWarehouseAccess();
		
		assertNotNull(dao);
	}
	
	@Test
	void testDAOType() {
		dao = new InMemoryWarehouseAccess();
		
		assertEquals("class com.ecommerce.platform.api.server.inmemory_warehouse.InMemoryWarehouseAccess", dao.getClass().toString());
	}
	
	@Test
	void testDAOSaveEmpty() {
		dao = new InMemoryWarehouseAccess();
		
		dao.saveAll(emptyComponentSpecsList);
		
		assertEquals(0, dao.findAll().size());
	}
	
	@Test
	void testDAOSaveOne() {
		dao = new InMemoryWarehouseAccess();
		
		dao.saveAll(oneComponentSpecsList);
		
		assertEquals(1, dao.findAll().size());
	}
	
	@Test
	void testDAOSaveSeven() {
		dao = new InMemoryWarehouseAccess();
		
		dao.saveAll(sevenComponentSpecsList);
		
		assertEquals(7, dao.findAll().size());
	}
	
	@Test
	void testDAOFindAll() {
		dao = new InMemoryWarehouseAccess();
		
		dao.saveAll(sevenComponentSpecsList);
		
		assertEquals(7, dao.findAll().size());
	}
}
