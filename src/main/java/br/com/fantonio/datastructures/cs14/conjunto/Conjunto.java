package br.com.fantonio.datastructures.cs14.conjunto;

import java.util.List;

public interface Conjunto<E> {

    void adiciona(E e);

    void remove(E e);

    boolean contem(E e);

    List<E> pegaTodas();

    int tamanho();

}
