package com.ecommerce.platform.api.admin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class AdministratorTest {

	private Administrator administrator;
	
	@BeforeAll
    public void initializeTestData() {
			
		administrator = new Administrator(1,2,3,4);
	}
	
	@Test
	public void testAdministratorNotNull() {
		assertNotNull(administrator);
	}
	
	@Test
	public void testGetConnectedClients() {
		assertEquals(1, administrator.getConnectedClients());
	}
	
	@Test
	public void testGetOrdersInAssemblers() {
		assertEquals(2, administrator.getOrdersInAssemblers());
	}
	
	@Test
	public void testGetWaitingOrders() {
		assertEquals(3, administrator.getWaitingOrders());
	}
	
	@Test
	public void testGetMemoryUsageInMB() {
		assertEquals(4, administrator.getMemoryUsageInMB());
	}
}
