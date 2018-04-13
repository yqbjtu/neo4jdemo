package com.yq.repository;

import com.yq.domain.CategoryModel;
import org.springframework.data.neo4j.repository.Neo4jRepository;

/**
 */
public interface CategoryModelRepository extends Neo4jRepository<CategoryModel, Long> {

    CategoryModel findByName(String name);
}