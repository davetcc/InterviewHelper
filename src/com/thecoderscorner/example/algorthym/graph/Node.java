package com.thecoderscorner.example.algorthym.graph;

import java.util.Collections;
import java.util.List;

/**
 * This is an example of a node in a graph structure, for the purpose of
 * simplicity this graph has no means of traversing from parent to child,
 * however it would be quite simple to add such extra capabilities.
 *
 * This is not designed to be a complete exemplar of how to build a graph
 * node, but rather a starting point, for the purpose of example only.
 */
public class Node {
    private final List<Node> children;
    private final String nodeName;
    private boolean visited;

    /**
     * create a node with more than one child element.
     * @param nodeName the name of this node
     * @param children the children to attach.
     */
    public Node(String nodeName, List<Node> children) {
        this.children = children;
        this.nodeName = nodeName;
    }

    /**
     * create a leaf node.
     * @param nodeName the node name
     */
    public Node(String nodeName) {
        this.children = Collections.emptyList();
        this.nodeName = nodeName;
    }

    /**
     * special case to create a node with one child.
     * @param nodeName the node name
     * @param node child node
     */
    public Node(String nodeName, Node node) {
        this.nodeName = nodeName;
        this.children = Collections.singletonList(node);
    }

    /**
     * Get a read only copy of the list of child items.
     * @return read only list of child items
     */
    public List<Node> getChildren() {
        return Collections.unmodifiableList(children);
    }

    /**
     * gets the name of the node.
     */
    public String getNodeName() {
        return nodeName;
    }

    /**
     * gets the visited status of the node
     * @return the visited status.
     */
    public boolean isVisited() {
        return visited;
    }

    /**
     * sets the visited status of the list.
     * @param visited visited status
     */
    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    @Override
    public String toString() {
        return String.format("%s, visited: %b, children: %d", nodeName, visited, children.size());
    }
}
