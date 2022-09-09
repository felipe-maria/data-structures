package br.com.fantonio.datastructures.sort.quicksort;

import br.com.fantonio.datastructures.sort.Sort;

public class Quicksort implements Sort {

    @Override
    public void sort(Integer[] array) {

        this.quickSort(array, 0, array.length - 1);
    }

    private void quickSort(Integer[] array, int leftBound, int rightBound) {

        // Base condition. Lists with size 0 or 1 because it's already sorted.
        if (rightBound - leftBound <= 0) {
            return;
        } else {
            int pivot = array[rightBound];
            int partition = partitionFunction(array, leftBound, rightBound, pivot);
            quickSort(array, leftBound, partition - 1);
            quickSort(array, partition+1, rightBound);
        }

    }

    /**
     * Sort a pivot inside a partition defined by the bound
     * 
     * @param array
     * @param leftBound
     * @param rightBound
     * @param pivot
     * @return
     */
    private int partitionFunction(Integer[] array, int leftBound, int rightBound, int pivot) {
        
        int leftPointer = leftBound;
        int rightPointer = rightBound - 1; // to avoid checking the pivot value

        while (true) {

            // Check for a value greater than pivot to swap it
            while (array[leftPointer] < pivot) {
                leftPointer++;
            }

            // Check for a value minor than pivot to swap it
            while (rightPointer > 0 && array[rightPointer] > pivot) {
                rightPointer--;
            }

            // Right crossed bounds
            if (leftPointer >= rightPointer) {
                break;
            } else {
                // Swap positions between left and right poitner
                swap(array, leftPointer, rightPointer);
            }
        }

        // swap the pivot
        swap(array, leftPointer, rightBound);

        return leftPointer;
    }

    /**
     * Swap positions in the array due to the left and right pointers
     * @param array
     * @param leftPointer
     * @param rightPointer
     */
    private void swap(Integer[] array, int leftPointer, int rightPointer) {
        Integer leftValue = array[leftPointer];
        Integer rightValue = array[rightPointer];

        array[leftPointer] = rightValue;
        array[rightPointer] = leftValue;
    }

}
