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
    public void insere(E element) {
        garantirEspaco();
        elements[++index] = element;
        tamanho++;
    }


    /**
     * Pop
     * @return
     */
    public E remove() throws EmptyStackException {
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
    public boolean vazia() {
        return tamanho == 0;
    }

    // Search
    // Peek

    private void garantirEspaco() {
        if (elements.length - 1 == index) {
            dobrarArray();
        }
    }

    private void dobrarArray() {
        E[] novoArray = (E[]) new Object[tamanho * 2];

        for (int i = 0; i < tamanho; i++) {
            novoArray[i] = elements[i];
        }

        elements = novoArray;
    }

}
