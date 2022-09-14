package br.com.fantonio.datastructures.search;

public class BinarySearch<E extends Comparable<E>> implements Search<E> {

    @Override
    public int search(E[] elements, E element) throws IllegalArgumentException {

        if (element == null) {
            throw new IllegalArgumentException("Null element");
        }

        if (elements == null) {
            throw new IllegalArgumentException("Null array");
        }

        if (elements.length == 0) {
            throw new IllegalArgumentException("Empty array");
        }

        return sort(elements, element, 0, elements.length-1);
    }

    private int sort(E[] elements, E element, int lowBound, int highBound) {

        if (lowBound == highBound) {
            if (element.equals(elements[highBound])) {
                return highBound;
            } else {
                return -1;
            }
        }

        // pega o elemento central. se não houver, pega mais a esquerda
        int centralIndex = (lowBound - 1) + ((highBound - lowBound) / 2 ) + ((highBound - lowBound) % 2);
        int compare = element.compareTo(elements[centralIndex]);

        if (compare == 0) {
            return centralIndex;
        } else if (compare == -1) {
            return sort(elements, element, lowBound, centralIndex);
        } else {
            return sort(elements, element,centralIndex+1, highBound);
        }
    }

}
