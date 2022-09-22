package br.com.fantonio.datastructures.cs14.lista;

import java.util.Arrays;

/**
 * Implementação de uma lista usando um array.
 */
public class Vetor<E> implements Lista<E> {

    private static final int defaultSize = 100;

    private final ListBasicOperation<E> listOperations = new ListBasicOperation<>();

    private int index = -1;
    private int size = 0;

    private E[] items;

    public Vetor() {
        this.items = (E[]) new Object[defaultSize];
    }

    public Vetor(int size) {
        this.items = (E[]) new Object[size];
    }

    @Override
    public void adiciona(E item) {
        this.size++;
        garantirEspaco();
        this.items[++this.index] = item;
    }

    @Override
    public void adiciona(int posicao, E item) throws IllegalArgumentException {
        this.size++;
        if (!posicaoValida(posicao)) {
            throw new IllegalArgumentException("Posicao inválida");
        }
        garantirEspaco();
        if (this.items[posicao] != null) {
            for (int i = this.index + 1; i > posicao; i--) {
                this.items[i] = this.items[i - 1];
            }
        }
        this.items[posicao] = item;
        this.index++;
    }

    @Override
    public E pega(int posicao) throws IllegalArgumentException {
        if (posicaoValida(posicao)) {
            return this.items[posicao];
        }
        throw new IllegalArgumentException("Posicao inválida");
    }

    @Override
    public void remove(int posicao) {
        this.items[posicao] = null;
        for (int i = posicao + 1; i < this.size; i++) {
            this.items[i - 1] = this.items[i];
        }
        this.items[this.index] = null;
        this.index--;
        this.size--;
    }

    @Override
    public void remove(E item) {
        for (int i = 0; i < this.size; i++) {
            if (this.items[i].equals(item)) {
                this.items[i] = null;
            }
        }
        compactarItems();
    }

    @Override
    public boolean contem(E item) {
        if (item == null) return false;

        for (Object o : this.items) {
            if (item.equals(o)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public int tamanho() {

        return this.size;
    }

    @Override
    public String toString() {
        return Arrays.toString(this.items);
    }

    @Override
    public E[] toArray() {
        E[] itemsClone = (E[]) new Object[this.items.length];
        copiarArray(this.items, itemsClone);

        return itemsClone;
    }

    @Override
    public void limpar() {
        this.items = (E[]) new Object[defaultSize];
        this.index = -1;
        this.size = 0;
    }

    @Override
    public int indexOf(E o) {
        if (o == null) return -1;
        if (size == 0) return -1;

        for (int i = 0; i < size; i++) {
            Object item = items[i];
            if (o.equals(item)) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        if (o == null) return -1;
        if (size == 0) return -1;

        for (int i = size -1; i >= 0; i--) {
            Object item = items[i];
            if (o.equals(item)) {
                return i;
            }
        }

        return -1;
    }

    private void copiarArray(E[] origem, E[] destino) {
        for (int i = 0; i < origem.length && origem[i] != null; i++) {
            destino[i] = origem[i];
        }
    }

    private boolean posicaoValida(int posicao) {
        return posicao >= 0 && posicao < this.size;
    }

    private void garantirEspaco() {
        if (this.size > this.items.length) {
            E[] novoArray = listOperations.dobrarTamanhoArray(items);
            this.items = novoArray;
        }
    }

    private void compactarItems() {
        E[] novoArray = (E[]) new Object[items.length];

        this.index = -1;
        this.size = 0;

        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i] != null) {
                novoArray[++this.index] = this.items[i];
                this.size++;
            }
        }
        this.items = novoArray;
    }

}
