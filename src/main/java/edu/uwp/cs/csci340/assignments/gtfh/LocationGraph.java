package edu.uwp.cs.csci340.assignments.gtfh;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LocationGraph {

    // I chose to use a Map as the underlying data structure for my adjacency list
    // Probably should use generics here, but I didn't want to include extra handling since it's not in the scope of the assignment.
    private final Map<String, List<Edge>> adjacencyList = new HashMap<>();

    /** Adds a location to the adjacency list. Note that this strictly adds the label of the location and **NOT** its associated connections.
     * @param location String representation of the name of the location
     */
    public void addLocation(String location) {
        // Uses a blank arraylist as the edge list since there aren't any edges defined yet
        adjacencyList.put(location, new ArrayList<>());
    }

    /** Adds an Edge between two specified Nodes, and adds the information to the adjacency list. Note: if a Node isn't present in the adjacency list, this first adds the Node to the list
     * @param from A string representation of the origin location label
     * @param to A string representation of the destination location label
     * @param distance A double representation of the distance between locations
     */
    public void addPath(String from, String to, double distance) {
        // Puts the locations in the adjacency list (with no defined edges) in case they were not previously defined
        if(!adjacencyList.containsKey(from)) {
            adjacencyList.put(from, new ArrayList<>());
        } else if(!adjacencyList.containsKey(to)) {
            adjacencyList.put(to, new ArrayList<>());
        }

        // Adds the edge to the edge list. This must be done for both locations since it's undirected
        adjacencyList.get(to).add(new Edge(to, from, distance));
        adjacencyList.get(from).add(new Edge(to, from, distance));
    }


    /**
     * Inner class for an Edge object. It contains a destination and the length to it
     */
    private static class Edge {
        private String to;
        private String from;
        private double length;

        /**
         * Default Constructor for an Edge object
         */
        Edge() {
            this.to = "";
            this.from = "";
            this.length = 0.0;
        }

        /** 3-Parameter Constructor for an Edge object
         * @param to A string representation of the location the edge comes from
         * @param from A string representation of where the edge is pointing to
         * @param length A double representation of the distance between the locations
         */
        Edge(String to, String from, double length) {
            this.to = to;
            this.from = from;
            this.length = length;
        }
    }

    /**
     * Private Inner class for a Node object, which contains a name label
     */
    private static class Node {
        private String name;


        /**
         * Default Constructor a Node object
         */
        Node() {
            this.name = "";
        }

        /** One-parameter Constructor for a Node object
         * @param name
         */
        Node(String name) {
            this.name = name;
        }
    }
}
