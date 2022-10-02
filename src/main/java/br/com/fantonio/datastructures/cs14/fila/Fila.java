package br.com.fantonio.datastructures.cs14.fila;

import br.com.fantonio.datastructures.cs14.lista.ListaDuplamenteLigada;

public class Fila<E> {

    private ListaDuplamenteLigada<E> lista = new ListaDuplamenteLigada<>();

    public void insere(E element) {
        lista.adiciona(element);
    }

    public E remove() {
        return lista.removeDoComeco();
    }

    public boolean vazia() {
        return lista.tamanho() == 0;
    }

}
