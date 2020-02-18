package com.ecommerce.platform.api.server.controller;

import java.util.concurrent.ExecutionException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.ecommerce.platform.api.server.order.OrderDTO;
import com.ecommerce.platform.api.server.order.OrderStatusDTO;
import com.ecommerce.platform.api.server.service.OrderService;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("api/v1")
@EnableWebMvc
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@ModelAttribute
	public void setResponseHeader(HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
	}
	
	@PostMapping(value = "/orders/create", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	@ResponseBody
	public Flux<OrderStatusDTO> create(@RequestBody OrderDTO orderDTO) throws InterruptedException, ExecutionException {	
		return orderService.create(orderDTO);
	}
}