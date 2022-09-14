package br.com.fantonio.datastructures.search;

public interface Search<E extends Comparable<E>> {

    int search(E[] elements, E element) throws IllegalArgumentException;

}
