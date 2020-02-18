package com.ecommerce.platform.api.server.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.platform.api.server.component.ComponentSpecs;

@Repository
public interface IComponentRepository extends CrudRepository<ComponentSpecs, Long> {
	List<ComponentSpecs> findByNameContainingIgnoreCase(String name);
	ComponentSpecs findByid(UUID id);
}
