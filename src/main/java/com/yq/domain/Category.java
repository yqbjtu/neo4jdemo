package com.yq.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.List;

/**
 * Simple to Introduction
 * className: Category
 *
 * @author yqbjtu
 * @version 2018/4/6 21:42
 */
@lombok.Data
@NodeEntity
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String picUrl;

    @Relationship(type = "Category_2_Model", direction = Relationship.OUTGOING)
    private List<CategoryModel> models;

    public Category(String name, String picUrl) {
        this.name = name;
        this.picUrl = picUrl;
    }
    //Entities handled by the OGM must have one empty public constructor to allow the library to construct the objects.
    public void addModel(CategoryModel model) {
        if (this.models == null) {
            this.models = new ArrayList<>();
        }
        this.models.add(model);
    }

}
