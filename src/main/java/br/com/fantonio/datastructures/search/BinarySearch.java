package br.com.fantonio.datastructures.search;

public class BinarySearch<E> implements Search<E> {

    @Override
    public int search(E[] array, E element) throws IllegalArgumentException {
        if (array == null) {
            throw new IllegalArgumentException("Null array");
        }

        if (array.length == 0) {
            throw new IllegalArgumentException("Empty array");
        }

        return -1;
    }

}
