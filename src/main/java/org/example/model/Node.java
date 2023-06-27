package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Node {

    private float x;

    private float y;

    private List<RouteIntersectingPoint> intersectingRoutes;

}
