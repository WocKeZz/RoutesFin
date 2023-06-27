package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.*;
import org.example.nodefiller.NodeFiller;
import org.example.nodefiller.SimpleNodeFiller;
import org.example.nodeprocessing.NodeProcessing;
import org.example.nodeprocessing.SimpleNodeProcessing;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        FeatureCollection featureCollection =
                objectMapper.readValue(new File("src/main/java/org/example/map.json"), FeatureCollection.class);
        List<Route> routes = new ArrayList<>();
        List<Node> nodes = new ArrayList<>();
        NodeFiller nodeFiller = new SimpleNodeFiller();
        NodeProcessing nodeProcessing = new SimpleNodeProcessing();

        for (Feature feature : featureCollection.getFeatures()) {
            routes.add(new Route(feature.getProperties().getDescription(), feature.getGeometry().getCoordinates()));
        }

        nodeFiller.fill(routes, nodes);

        nodeProcessing.process(nodes);

        for (Route route : routes) {
            for (Feature feature : featureCollection.getFeatures()) {
                if (route.getDescription().equals(feature.getProperties().getDescription())) {
                    for (int i = 0; i < route.getCoordinates().length; i++) {
                        feature.getGeometry().getCoordinates()[i] = route.getCoordinates()[i];
                    }
                }
            }
        }

        objectMapper.writeValue(new File("src/main/java/org/example/output.json"), featureCollection);
    }
}
