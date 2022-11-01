package br.com.fantonio.datastructures.cs14.map;

public interface Mapa<K,V> {

    void adiciona(K chave, V valor);
    V pega(K chave);
    void remove(K chave);
    boolean existe(K chave);
    int quantidade();

}
