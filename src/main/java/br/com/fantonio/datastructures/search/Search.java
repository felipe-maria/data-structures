package br.com.fantonio.datastructures.search;

public interface Search<E> {

    int search(E[] array, E element) throws IllegalArgumentException;

}
