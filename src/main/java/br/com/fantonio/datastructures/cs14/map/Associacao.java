package br.com.fantonio.datastructures.cs14.map;

public class Associacao<K,V> {

    private K key;
    private V value;

    public Associacao(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

}
