package com.yq.repository;

import com.yq.domain.Category;
import com.yq.domain.Device;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

/**
 */
public interface DeviceRepository extends Neo4jRepository<Device, Long> {

	Device findByName(@Param("name") String name);

}