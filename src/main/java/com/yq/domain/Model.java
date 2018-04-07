package com.yq.domain;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.neo4j.ogm.annotation.*;

/**
 */
@RelationshipEntity(type = "BELONG_TO")
public class Model {

    @Id
    @GeneratedValue
	private Long id;

	@StartNode
	private CategoryModel categoryModel;

	@EndNode
	private Category category;
	public Model() {
	}

	public Model(CategoryModel categoryModel, Category category) {
		this.categoryModel = categoryModel;
		this.category = category;
	}

	public Long getId() {
	    return id;
	}


	public CategoryModel getCategoryModel() {
	    return categoryModel;
	}

	public Category getCategory() {
	    return category;
	}

}