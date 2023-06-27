package org.example.model;

import lombok.Data;

import java.util.List;

@Data
public class FeatureCollection {

    private String type;

    private MetaData metadata;

    private List<Feature> features;
}
