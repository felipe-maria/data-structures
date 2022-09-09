package br.com.fantonio.datastructures.sort;

public class InsertionSort implements Sort {


    /**
     * Classic implementation
     * @param array
     */
    @Override
    public void sort(Integer[] array) {

        for (int i = 1; i <= array.length - 1; i++) {
            int value = array[i];
            int hole = i;

            while (hole > 0 && array[hole -1] > value) {
                array[hole] = array[hole - 1];
                hole = hole-1;
            }
            array[hole] = value;
        }
    }


    /**
     * My implementation when I tried to write this algorithm
     * @param array
     */
    public void personalSort(Integer[] array) {

        for (int i = 1; i <= array.length - 1; i++) {
            if (array[i] < array[i - 1]) {
                swap(array, i, i - 1);
                for (int k = i - 1; k >= 1; k--) {
                    if (array[k] < array[k - 1]) {
                        swap(array, k, k - 1);
                    } else {
                        break;
                    }
                }
            }
        }
    }

    private void swap(Integer[] array, int indexA, int indexB) {
        int valueA = array[indexA];
        int valueB = array[indexB];

        array[indexA] = valueB;
        array[indexB] = valueA;
    }

}
