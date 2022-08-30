package br.com.fantonio.datastructures.quicksort;

public class Quicksort {

    public void sort(Integer[] array) {
        this.quickSort(array, 0, array.length - 1);
    }

    private void quickSort(Integer[] array, int iLeft, int iRight) {

        if (iRight - iLeft <= 0) {
            return;
        } else {
            int pivot = array[iRight];
            int partition = partitionFunction(array, iLeft, iRight, pivot);
            quickSort(array, iLeft, partition - 1);
            quickSort(array, partition+1, iRight);
        }

    }


    private int partitionFunction(Integer[] array, int iLeft, int iRight, int pivot) {

        int leftPointer = iLeft;
        int rightPointer = iRight - 1;

        while (true) {
            while (array[leftPointer] < pivot) {
                leftPointer++;
            }

            while (rightPointer > 0 && array[rightPointer] > pivot) {
                rightPointer--;
            }

            // Right crossed bounds
            if (leftPointer >= rightPointer) {
                break;
            } else {

                Integer leftValue = array[leftPointer];
                Integer rightValue = array[rightPointer];

                array[leftPointer] = rightValue;
                array[rightPointer] = leftValue;
            }
        }

        Integer leftValue = array[leftPointer];
        Integer rightValue = array[iRight];

        array[leftPointer] = rightValue;
        array[iRight] = leftValue;

        return leftPointer;
    }


}
