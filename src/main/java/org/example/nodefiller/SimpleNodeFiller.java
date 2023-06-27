package org.example.nodefiller;

import org.example.model.Node;
import org.example.model.Route;
import org.example.model.RouteIntersectingPoint;

import java.util.ArrayList;
import java.util.List;

public class SimpleNodeFiller implements NodeFiller {


    @Override
    public void fill(List<Route> routes, List<Node> nodes) {
        for (Route route : routes) {
            int i = 1;
            for (float[] pointCoordinates : route.getCoordinates()) {
                boolean isInNode = false;
                for (Node node : nodes) {
                    if (node.getX() == pointCoordinates[1] && node.getY() == pointCoordinates[0]) {
                        node.getIntersectingRoutes().add(new RouteIntersectingPoint(route, i));
                        isInNode = true;
                        break;
                    }
                }
                if (!isInNode) {
                    nodes.add(new Node(pointCoordinates[1],
                            pointCoordinates[0],
                            new ArrayList<>(List.of(new RouteIntersectingPoint(route, i)))));
                }
                i++;
            }
        }
    }
}
