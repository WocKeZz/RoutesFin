package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RouteIntersectingPoint {

    private Route route;

    private int position;
}
