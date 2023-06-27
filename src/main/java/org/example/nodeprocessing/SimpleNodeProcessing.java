package org.example.nodeprocessing;

import org.example.model.Node;
import org.example.model.RouteIntersectingPoint;

import java.util.List;

public class SimpleNodeProcessing implements NodeProcessing {

    private final float indent = 0.0001f;

    @Override
    public void process(List<Node> nodes) {
        for (Node node : nodes) {
            int step = 0;
            for (RouteIntersectingPoint routeIntersectingPoint : node.getIntersectingRoutes()) {
                routeIntersectingPoint.getRoute().getCoordinates()[routeIntersectingPoint.getPosition() - 1][1] =
                        routeIntersectingPoint.getRoute().getCoordinates()[routeIntersectingPoint.getPosition() - 1][1] + (indent * step);
                step++;
            }
        }
    }
}
