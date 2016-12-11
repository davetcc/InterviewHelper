package com.thecoderscorner.example.algorthym.graph;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Iterates through all the nodes in the graph depth first such that it will
 * go down before across. In addition this takes care not to traverse any nodes
 * in the tree more than once.
 *
 * This is the traditional computer science based recursive algo most people are
 * taught quite early on during studies.
 */
public class DepthFirstGraph {
    private static final Logger logger = LoggerFactory.getLogger(DepthFirstGraph.class);

    public static void main(String[] args) {
        // just call the recursive method with the root element, and it will
        // recurse through every element. On systems where recursion is not
        // allowed just take the breadth first example and change the queue
        // to a stack.
        processDepthFirst(SampleGraphs.sampleGraphWithSharedLastChild());
    }


    private static void processDepthFirst(Node node) {

        node.setVisited(true);
        logger.info("Visit: " + node);

        // loop over each element, and put anything not yet visited on the stack
        for (Node child : node.getChildren()) {
            if(!child.isVisited()) {
                processDepthFirst(child);
            }
        }

    }

}
