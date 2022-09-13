package br.com.fantonio.datastructures.cs14;

public interface Lista<E> {

    void adiciona(E element);

    void adiciona(int posicao, E element) throws IllegalArgumentException;

    Object pega(int posicao) throws IllegalArgumentException;

    void remove(int posicao);

    void remove(E item);

    boolean contem(E item);

    int tamanho();

    Object[] toArray();

    void limpar();

    int indexOf(E o);

    int lastIndexOf(E o);

}


