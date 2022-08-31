package br.com.fantonio.datastructures.selectionsort;

public class SelectionSort {


    public void sort(Integer[] array) {

        int pivotPointer = 0;
        int rightBound = array.length-1;

        do {

            int pointer = pivotPointer;
            int lowestValuePointer = pointer;

            while (pointer <= rightBound) {

                if (array[pointer] < array[lowestValuePointer]) {
                    lowestValuePointer = pointer;
                }

                pointer++;
            }

            swap(array, pivotPointer, lowestValuePointer);

        } while (pivotPointer++ < rightBound);

    }

    private void swap(Integer[] array, int pivotPointer, int lowestPosition) {
        int pivotValue = array[pivotPointer];
        int lowestValue = array[lowestPosition];

        array[pivotPointer] = lowestValue;
        array[lowestPosition] = pivotValue;
    }
}
