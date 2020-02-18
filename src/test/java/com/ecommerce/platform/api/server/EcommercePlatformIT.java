package com.ecommerce.platform.api.server;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.ecommerce.platform.api.EcommercePlatformApp;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = EcommercePlatformApp.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class EcommercePlatformIT {
	
	@LocalServerPort
	private int port;
	
	@Test
	public void testFindAll() throws IOException {
		
		TestRestTemplate restTemplate = new TestRestTemplate();
		ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:" + port + "/api/v1/components", String.class);
		
		assertEquals(HttpStatus.OK, response.getStatusCode()); 
		
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode responseJson = objectMapper.readTree(response.getBody());
		
		assertEquals(false, responseJson.isMissingNode());
		assertNotEquals("[]", responseJson.toString());
	}
	
	@Test
	public void testFindByName() throws IOException {
		
		TestRestTemplate restTemplate = new TestRestTemplate();
		ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:" + port + "/api/v1/components/name=" + "Intel Core i7-8809G".toUpperCase(), String.class);
		
		assertEquals(HttpStatus.OK, response.getStatusCode()); 
		
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode responseJson = objectMapper.readTree(response.getBody());
		
		assertEquals(false, responseJson.isMissingNode());
		assertNotEquals("[]", responseJson.toString());
	}
	
	@Test
	public void testGetQuantity() throws Exception {
			
		TestRestTemplate restTemplate = new TestRestTemplate();
		ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:" + port + "/api/v1/components/quantity", String.class);
		
		assertEquals(HttpStatus.OK, response.getStatusCode()); 
		
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode responseJson = objectMapper.readTree(response.getBody());
		
		assertEquals(false, responseJson.isMissingNode());
		assertEquals("100", responseJson.toString());
	}
}
