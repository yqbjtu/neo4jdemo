


package com.yq.domain;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

/**
 * Simple to Introduction
 * className: Device
 *
 * @author YangQian
 * @version 2018/4/6 21:42
 */
@NodeEntity
@lombok.Data
public class Device {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
}
