package com.thecoderscorner.example.algorthym.sorting;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * This is a quick sort algo based on the "Hoare partition scheme". After each
 * iteration, it partitions the array into smaller chunks, in order
 * to achieve much greater efficiency than quick sort.
 * This sort is just greater than O(log N) by about 1.3 times.
 */
public class QuickSort {
    private final Logger logger = LoggerFactory.getLogger(QuickSort.class);
    private int swapCount = 0;
    private int numbersToSort[] = {97, 34, 232, 43, 1, 454, 23, 11, 12, 22};

    public static void main(String[] args) {
        QuickSort sorter = new QuickSort();
        sorter.start();
    }

    /**
     * here we just log out the un-sorted state of the array, kick of the sort
     * the log out the sorted state and the number of sort operations.
     */
    void start() {
        logElements(numbersToSort);

        quickSort(0, numbersToSort.length-1);

        logElements(numbersToSort);
        logger.info("Number of swaps: " + swapCount);
    }

    /**
     * This type of sort is recursive, so we just keep splitting the problem
     * into smaller array parts, based on where our partition has currently
     * sorted.
     *
     * @param left the lower bound
     * @param right the upper bound
     */
    private void quickSort(int left, int right) {
        if(left < right) {
            int partition = partition(left, right, numbersToSort[right]);

            quickSort(left, partition - 1);
            quickSort(partition, right);
        }
    }

    /**
     * here we find items tht needs swapping over and also find the new point at
     * which to partition the array upon return.
     */
    private int partition(int left, int right, int pivot) {
        int leftPoint = left;
        int rightPoint = right;

        // while the left point is still smaller.
        while(leftPoint < rightPoint) {

            // first point to the left where leftPoint is smaller than pivot
            while(numbersToSort[leftPoint] < pivot) {
                ++leftPoint;
            }

            // first point from the right where right is bigger than pivot.
            while(rightPoint > 0 && numbersToSort[rightPoint] > pivot) {
                --rightPoint;
            }

            // if left is smaller then effect a copy.
            if(leftPoint < rightPoint) {
                swap(leftPoint, rightPoint);
            }
        }

        // this is the new pivot
        return leftPoint;
    }

    /**
     * swap over the two elements of the array.
     * @param idx1 first index to swap
     * @param idx2 second index to swap
     */
    private void swap(int idx1, int idx2) {
        int temp = numbersToSort[idx1];
        numbersToSort[idx1] = numbersToSort[idx2];
        numbersToSort[idx2] = temp;
        ++swapCount;
    }

    private void logElements(int[] numbers) {
        logger.info("Elements: " + Arrays.stream(numbers)
                .mapToObj(Integer::toString)
                .collect(Collectors.joining(", "))
        );
    }
}
