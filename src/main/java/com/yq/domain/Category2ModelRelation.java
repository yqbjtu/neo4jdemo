package com.yq.domain;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.neo4j.ogm.annotation.*;

/**
 */
@RelationshipEntity(type = "Category_2_Model")
public class Category2ModelRelation {

    @Id
    @GeneratedValue
	private Long id;

	@StartNode
	private Category category;

	@EndNode
	private CategoryModel categoryModel;

	public Category2ModelRelation() {
	}

	public Category2ModelRelation(CategoryModel categoryModel, Category category) {
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