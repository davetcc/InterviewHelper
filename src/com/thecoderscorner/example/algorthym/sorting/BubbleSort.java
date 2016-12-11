package com.thecoderscorner.example.algorthym.sorting;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Bubble sort is the slowest algorythm for sort, but also the easiest to
 * understand as it is entirely iterative.
 *
 * It basically keeps iterating over the array of numbers in a loop until
 * they are all in order. In big O notation it's the slowest sort: O(N pow2)
 */
public class BubbleSort {
    private static final Logger logger = LoggerFactory.getLogger(BubbleSort.class);

    public static void main(String[] args) {
        int numbersToSort[] = {454, 97, 34, 22, 43, 1, 23, 11, 12, 22};

        logElements(numbersToSort);

        // we need to loop until there is nothing else to sort.
        boolean somethingSortedLastTurn=true;
        int iterations = 0;
        while(somethingSortedLastTurn) {
            somethingSortedLastTurn = false;

            // loop over the whole array
            for (int i = 0; i < numbersToSort.length - 1; ++i) {
                // looking for cases where items are out of order.
                if (numbersToSort[i] > numbersToSort[i + 1]) {
                    // swap the components over.
                    int temp = numbersToSort[i];
                    numbersToSort[i] = numbersToSort[i + 1];
                    numbersToSort[i+1] = temp;

                    // and set the flag to say we sorted something
                    // meaning we need to go again.
                    somethingSortedLastTurn = true;
                }
            }
            ++iterations;
        }

        logElements(numbersToSort);
        logger.info("Iterations taken: {}, compare operations: {}", iterations, numbersToSort.length * iterations);
    }

    private static void logElements(int[] numbers) {
        logger.info("Elements: " + Arrays.stream(numbers)
                .mapToObj(Integer::toString)
                .collect(Collectors.joining(", "))
        );
    }
}
