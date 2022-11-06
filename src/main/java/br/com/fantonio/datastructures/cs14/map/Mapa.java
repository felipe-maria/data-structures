package br.com.fantonio.datastructures.cs14.map;

import java.util.Collection;

public interface Mapa<K,V> {

    void adiciona(K chave, V valor);
    V pega(K chave);
    void remove(K chave);
    boolean contemChave(K chave);
    int quantidade();
    Collection<V> pegaTodos();

}
