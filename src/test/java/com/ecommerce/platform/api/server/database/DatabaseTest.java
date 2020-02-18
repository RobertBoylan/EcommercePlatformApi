package com.ecommerce.platform.api.server.database;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.ecommerce.platform.api.server.dao.IDAO;

public class DatabaseTest {
	
	@MockBean
	protected IDAO dao;
	
	@Test
	private void testShouldReturn0() {
		when(dao.count()).thenReturn(0L);
		
		assertEquals(0L, dao.count());
	}
	
	@Test
	private void testShouldReturn10() {
		
		when(dao.count()).thenReturn(10L);
		
		assertEquals(10L, dao.count());
	}

	@Test
	private void testShouldReturn850() {
		when(dao.count()).thenReturn(850L);
		
		assertEquals(850L, dao.count());
	}
}
