package com.yq.repository;

import java.util.Collection;

import  com.yq.domain.Category;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

/**
 */
public interface CategoryRepository extends Neo4jRepository<Category, Long> {

	Category findByName(@Param("name") String name);

	Collection<Category> findByNameLike(@Param("name") String name);

	//MATCH (n:CategoryModel)-[r:BELONG_TO]->() RETURN n LIMIT 25

}