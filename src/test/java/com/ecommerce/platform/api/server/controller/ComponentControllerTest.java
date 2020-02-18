package com.ecommerce.platform.api.server.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.ecommerce.platform.api.EcommercePlatformApp;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = EcommercePlatformApp.class)
public class ComponentControllerTest {

	@Autowired
	private ComponentController componentController;
	
	@Test
	public void testFindAll() {
		
		assertNotNull(componentController.findAll().get(0));
	}
	
	@Test
	void testFindByName() {

		assertEquals(3, componentController.findByName("BW X Chroma-Multi-color".toUpperCase()).size());
	}
	
	@Test
	void testGetQuantity() {
		
		assertEquals(100, componentController.getQuantity());
	}
}