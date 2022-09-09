package br.com.fantonio.datastructures.sort.selectionsort;

import br.com.fantonio.datastructures.sort.Sort;

public class SelectionSort implements Sort {

    @Override
    public void sort(Integer[] array) {

        for (int i = 0; i < array.length-1; i++) {                            // 1 + 1 + n * (laço interno) + n
            int smallPointer = i;                                           // 1
            for (int j = i; j < array.length; j++) {                        // 1 + 1 + (n -1) + n-1
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
