package org.example.model;

import lombok.Data;

@Data
public class Feature {

    private String type;

    private long id;

    private Geometry geometry;

    private Properties properties;

}
