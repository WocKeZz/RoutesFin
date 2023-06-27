package org.example.nodefiller;

import org.example.model.Node;
import org.example.model.Route;

import java.util.List;


public interface NodeFiller {

    void fill(List<Route> routes, List<Node> nodes);
}
