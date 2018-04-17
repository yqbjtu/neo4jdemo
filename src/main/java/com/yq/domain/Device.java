


package com.yq.domain;

import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

/**
 * Simple to Introduction
 * className: Device
 *
 * @author YangQian
 * @version 2018/4/6 21:42
 */
@NodeEntity
@lombok.Data
@NoArgsConstructor
public class Device {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    @Relationship(type = "Model_2_Device", direction = Relationship.INCOMING)
    private CategoryModel categoryModel;
    public Device(String name) {
        this.name = name;
    }

}
