package com.ecommerce.platform.api.admin.service;

import com.ecommerce.platform.api.admin.Administrator;

import reactor.core.publisher.Flux;

public interface IAdministratorService {

	Flux<Administrator> getAdministrator();
}
