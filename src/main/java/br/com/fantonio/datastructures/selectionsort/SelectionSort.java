package br.com.fantonio.datastructures.selectionsort;

public class SelectionSort {


    public void sort(Integer[] array) {

        int pivotPointer = 0;
        int rightBound = array.length-1;
        int counter = 0;
        while (pivotPointer < rightBound) {

            int pointer = pivotPointer;
            int lowestValuePointer = pointer;

            while (pointer <= rightBound) {

                if (array[pointer] < array[lowestValuePointer]) {
                    lowestValuePointer = pointer;
                }

                pointer++;
                counter++;
            }

            swap(array, pivotPointer, lowestValuePointer);
            pivotPointer++;
        }

        System.out.println("Number of elements (n): " + array.length);
        System.out.println("Iterations: " + counter);
    }

    private void swap(Integer[] array, int pivotPointer, int lowestPosition) {
        int pivotValue = array[pivotPointer];
        int lowestValue = array[lowestPosition];

        array[pivotPointer] = lowestValue;
        array[lowestPosition] = pivotValue;
    }
}
