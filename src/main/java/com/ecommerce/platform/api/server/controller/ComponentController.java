package com.ecommerce.platform.api.server.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.ecommerce.platform.api.server.component.ComponentSpecs;
import com.ecommerce.platform.api.server.service.ComponentService;

@RestController
@RequestMapping("api/v1")
@EnableWebMvc
public class ComponentController {
	
	@Autowired
	private ComponentService componentService;
	
	@ModelAttribute
	public void setResponseHeader(HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
	}
	
	@GetMapping(value = "/components/quantity")
	public long getQuantity() {
		return componentService.count();
	}
	
	@GetMapping(value = "/components/name={name}")
	public List<ComponentSpecs> findByName(@PathVariable String name) {
		return componentService.findByName(name);
	}
	
	@GetMapping(value = "/components")
	public List<ComponentSpecs> findAll() {
		return componentService.findAll();
	}
	
}
