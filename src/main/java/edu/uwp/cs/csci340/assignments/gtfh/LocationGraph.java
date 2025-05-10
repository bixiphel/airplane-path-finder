package edu.uwp.cs.csci340.assignments.gtfh;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LocationGraph {

    // I chose to use a Map as the underlying data structure for my adjacency list
    // Probably should use generics here, but I didn't want to include extra handling since it's not in the scope of the assignment.
    private final Map<String, List<Edge>> adjacencyList = new HashMap<>();

    /**
     * Inner class for an Edge object. It contains a destination and the length to it
     */
    private static class Edge {
        private String to;
        private double length;

        // Constructor for an Edge object
        Edge(String from, String to, double length) {
            this.to = to;
            this.length = length;
        }
    }

    /**
     * Private Inner class for a Node object, which contains a name label
     */
    private static class Node {
        private String name;

        Node(String name, double distance) {
            this.name = name;
        }
    }
}
