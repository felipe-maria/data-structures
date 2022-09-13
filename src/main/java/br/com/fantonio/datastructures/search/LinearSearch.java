package br.com.fantonio.datastructures.search;

import java.util.Objects;

public class LinearSearch<E> implements Search<E> {

    @Override
    public int search(E[] array, E element) throws IllegalArgumentException{
        if (array == null) {
            throw new IllegalArgumentException("Null array");
        }

        if (array.length == 0) {
            throw new IllegalArgumentException("Empty array");
        }

        for (int i = 0; i < array.length; i++) {
            if (Objects.equals(element, array[i])) {
                return i;
            }
        }

        return -1;
    }
}
