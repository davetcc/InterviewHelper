package com.thecoderscorner.example.algorthym.graph;

import java.util.Arrays;
import java.util.Collections;

/**
 * This static utility class provides example node layouts that can be used to
 * test the various graph manipulation facilities that are provided.
 */
public class SampleGraphs {

    /**
     * Creates a multi-level graph/node data structure suitable for passing in
     * to the various graph manipulation examples.
     *
     *                Root (level1)
     *     |----------|----------|-----------|
     *  Level2=1   level2-3  Level2-2   level2-4
     *    |           |         |
     *    --Level3-S---      Level3-N
     *                          |
     *                       Level4
     *
     * @return a graph of nodes suitable for manipulation.
     */
    public static Node sampleGraphWithSharedLastChild() {

        Node level3Nested = new Node("Level3-Nested", Collections.singletonList(new Node("Level4")));

        Node sharedLastChild = new Node("Level3-Shared");

        return new Node("root-Level1", Arrays.asList(
                  new Node("level2-First", sharedLastChild),
                  new Node("level2-Second", level3Nested),
                  new Node("level2-Third", sharedLastChild),
                  new Node("level2-Fourth")
        ));
    }
}
