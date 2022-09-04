package br.com.fantonio.datastructures.selectionsort;

import java.util.HashMap;
import java.util.Map;

public class SelectionSort {

    public void sort(Integer[] array) {

        for (int i = 0; i < array.length; i++) {
            int smallPointer = i;
            for (int j = i; j < array.length; j++) {
                if (array[smallPointer] > array[j]) {
                    smallPointer = j;
                }
            }
            swap(array, i, smallPointer);
        }

    }

    private void swap(Integer[] array, int pivotPointer, int smallPointer) {
        int pivotValue = array[pivotPointer];
        int lowestValue = array[smallPointer];

        array[pivotPointer] = lowestValue;
        array[smallPointer] = pivotValue;
    }
}
