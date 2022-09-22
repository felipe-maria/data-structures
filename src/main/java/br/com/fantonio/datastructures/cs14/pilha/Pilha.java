package br.com.fantonio.datastructures.cs14.pilha;

import java.util.EmptyStackException;

public class Pilha<E> {

    private static int tamanhoPadrao = 10;

    private E[] elements;
    private int index = -1;
    private int tamanho = 0;

    public Pilha() {
        elements = (E[]) new Object[tamanhoPadrao];
    }

    /**
     * Push
     * @param element
     */
    public void push(E element) {
        assureSpace();
        elements[++index] = element;
        tamanho++;
    }


    /**
     * Pop
     * @return
     */
    public E pop() throws EmptyStackException {
        if (tamanho == 0) {
            throw new EmptyStackException();
        }

        E element = (E) elements[index];
        elements[index--] = null;
        tamanho--;

        return element;
    }

    /**
     * Empty
     * @return
     */
    public boolean empty() {
        return tamanho == 0;
    }

    public int search(E e) {
        // TODO Not implemented yet
        return 0;
    }

    public E peek() throws EmptyStackException {
        if (tamanho == 0) {
            throw new EmptyStackException();
        }
        return elements[index];
    }

    private void assureSpace() {
        if (elements.length - 1 == index) {
            doubleArraySize();
        }
    }

    private void doubleArraySize() {
        E[] novoArray = (E[]) new Object[tamanho * 2];

        for (int i = 0; i < tamanho; i++) {
            novoArray[i] = elements[i];
        }

        elements = novoArray;
    }

}
