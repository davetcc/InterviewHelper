package com.thecoderscorner.example.algorthym.graph;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Iterates a graph structure by first traversing the breadth of the graph, only then going down to the next level.
 */
public class BreadthFirstGraph {
    private static final Logger logger = LoggerFactory.getLogger(BreadthFirstGraph.class);

    public static void main(String[] args) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(SampleGraphs.sampleGraphWithSharedLastChild());

        while(!queue.isEmpty()) {
            Node node = queue.remove();
            node.setVisited(true);

            logger.info("Visit from queue: " + node);
            for (Node child : node.getChildren()) {

                if(!child.isVisited()) {
                    queue.add(child);
                    child.setVisited(true);
                    logger.info("Adding child: " + child);
                }

            }
        }
    }
}
