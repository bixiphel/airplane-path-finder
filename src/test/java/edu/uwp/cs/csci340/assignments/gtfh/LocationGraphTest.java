package edu.uwp.cs.csci340.assignments.gtfh;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LocationGraphTest {

    private LocationGraph graph;

    @BeforeEach
    void setUp() {
        graph = new LocationGraph();
        graph.addLocation("JFK");
        graph.addLocation("LAX");
        graph.addLocation("ORD");
        graph.addPath("JFK", "LAX", 2451);
        graph.addPath("JFK", "ORD", 740);
        graph.addPath("ORD", "LAX", 1744);
    }

    @Test
    void addLocation() {
        graph.addLocation("SFO");
        assertTrue(graph.toString().contains("SFO"));
    }

    @Test
    void addPath() {
        graph.addPath("SFO", "LAX", 337.2);
        assertTrue(graph.toString().contains("SFO") && graph.toString().contains("LAX") && graph.toString().contains("337.2"));
    }

    @Test
    void testToString() {
    }
}