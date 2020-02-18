package com.ecommerce.platform.api.server.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.ecommerce.platform.api.server.component.ComponentSpecs;
import com.ecommerce.platform.api.server.component.processing.ProcessingComponentSpecs;
import com.ecommerce.platform.api.server.controller.ComponentController;
import com.ecommerce.platform.api.server.service.ComponentService;
import com.ecommerce.platform.api.server.utilities.ExampleDataGenerator;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.containsString;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ComponentController.class)
@AutoConfigureMockMvc
public class WebLayerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
    private ObjectMapper objectMapper;
	
	@MockBean
	private ComponentService componentService;

	@Test
	public void testShouldReturnCountWhenValidRequest() throws Exception {
		when(componentService.count()).thenReturn(100L);
	
		mockMvc.perform(get("/api/v1/components/quantity")).andDo(print()).andExpect(status().isOk()).andExpect(content().string(containsString("100")));
	}
	
	@Test
	public void testShouldReturnAllComponentsWhenValidRequest() throws Exception {
		when(componentService.findAll()).thenReturn(Arrays.asList(ExampleDataGenerator.createExampleComputerComponentCPU(), ExampleDataGenerator.createExampleComputerComponentCPU()));
		
		MvcResult mvcResult = mockMvc.perform(get("/api/v1/components")).andDo(print()).andExpect(status().isOk()).andReturn();
		
		String contentAsString = mvcResult.getResponse().getContentAsString();
		
        List<ProcessingComponentSpecs> actual = objectMapper.readValue(contentAsString, new TypeReference<List<ProcessingComponentSpecs>>(){});

        assertEquals(2, actual.size());
	}
	
	@Test
	public void testShouldReturnComponentsWhenValidRequest() throws Exception {
		@SuppressWarnings({ "rawtypes", "unchecked" })
		List<ComponentSpecs> expected = new ArrayList();
		
		expected.add(ExampleDataGenerator.createExampleComputerComponentCPU());
		
        when(componentService.findByName(any(String.class))).thenReturn(expected);
        
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/components/name=FX-6100")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        String contentAsString = mvcResult.getResponse().getContentAsString();
        
        List<ProcessingComponentSpecs> actual = objectMapper.readValue(contentAsString, new TypeReference<List<ProcessingComponentSpecs>>(){});

        assertEquals(actual.size(), expected.size());
	}
}