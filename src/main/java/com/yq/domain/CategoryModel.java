


package com.yq.domain;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.Labels;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Properties;
import org.neo4j.ogm.annotation.Relationship;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Simple to Introduction
 * className: CategoryModel
 *
 * @author YangQian
 * @version 2018/4/6 21:41
 */
@NodeEntity
@lombok.Data
public class CategoryModel {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String data;
    @Properties
    private Map<String, Object> dynamicProps = new HashMap<>();


    public CategoryModel(String name, String data) {
        this.name = name;
        this.data =data;
    }

    public CategoryModel() {}
}
