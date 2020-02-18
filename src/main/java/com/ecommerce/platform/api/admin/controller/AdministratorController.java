package com.ecommerce.platform.api.admin.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.ecommerce.platform.api.admin.Administrator;
import com.ecommerce.platform.api.admin.service.AdministratorService;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("api/v1")
@EnableWebMvc
public class AdministratorController {

	@Autowired
	private AdministratorService administratorService;
	
	@ModelAttribute
	public void setResponseHeader(HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
	}
	
	@GetMapping(value = "/admin", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Administrator> getAdministrator() {
        return administratorService.getAdministrator();
	}
}
