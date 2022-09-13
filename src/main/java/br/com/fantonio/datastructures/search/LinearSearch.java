package br.com.fantonio.datastructures.search;

import java.util.Objects;

public class LinearSearch<E extends Comparable<E>> implements Search<E> {

    @Override
    public int search(E[] elements, E element) throws IllegalArgumentException{
        if (elements == null) {
            throw new IllegalArgumentException("Null array");
        }

        if (elements.length == 0) {
            throw new IllegalArgumentException("Empty array");
        }

        for (int i = 0; i < elements.length; i++) {
            if (Objects.equals(element, elements[i])) {
                return i;
            }
        }

        return -1;
    }
}
