
package com.yq.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.Labels;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.List;

/**
 * Simple to Introduction
 * className: Category
 *
 * @author YangQian
 * @version 2018/4/6 21:42
 */
@lombok.Data
@NodeEntity
public class Category {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String picUrl;

    @JsonIgnoreProperties("models")
    @Relationship(type = "BELONG_TO", direction = Relationship.INCOMING)
    private List<Model> models;

    public Category(String name, String picUrl) {
        this.name = name;
        this.picUrl = picUrl;
    }

    public Category() {}
    public void addModel(Model model) {
        if (this.models == null) {
            this.models = new ArrayList<>();
        }
        this.models.add(model);
    }

}
