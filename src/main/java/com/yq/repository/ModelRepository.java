package com.yq.repository;

import com.yq.domain.Model;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

/**
 */
public interface ModelRepository extends Neo4jRepository<Model, Long> {


}