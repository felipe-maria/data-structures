package br.com.fantonio.datastructures.cs14;

import java.util.Arrays;

/**
 * Implementação de uma lista usando um array.
 */
public class Vetor<E> implements Lista<E> {

    private static int valorPadrao = 100;

    private int index = -1;
    private int tamanho = 0;

    private Object[] items;

    public Vetor() {
        this.items = new Object[valorPadrao];
    }

    public Vetor(int tamanho) {
        this.items = new Object[tamanho];
    }

    @Override
    public void adiciona(E item) {
        this.tamanho++;
        garantirEspaco();
        this.items[++this.index] = item;
    }

    @Override
    public void adiciona(int posicao, E item) throws IllegalArgumentException {
        this.tamanho++;
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
    public Object pega(int posicao) throws IllegalArgumentException {
        if (posicaoValida(posicao)) {
            return this.items[posicao];
        }
        throw new IllegalArgumentException("Posicao inválida");
    }

    @Override
    public void remove(int posicao) {
        this.items[posicao] = null;
        for (int i = posicao + 1; i < this.tamanho; i++) {
            this.items[i - 1] = this.items[i];
        }
        this.items[this.index] = null;
        this.index--;
        this.tamanho--;
    }

    @Override
    public void remove(E item) {
        if (item == null) throw new IllegalArgumentException("Item nulo");

        for (int i = 0; i < this.tamanho; i++) {
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
            if (o != null && item.equals(o)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public int tamanho() {

        return this.tamanho;
    }

    @Override
    public String toString() {
        return Arrays.toString(this.items);
    }

    @Override
    public Object[] toArray() {
        Object[] itemsClone = new Object[this.items.length];
        copiarArray(this.items, itemsClone);

        return itemsClone;
    }

    @Override
    public void limpar() {
        this.items = new Object[valorPadrao];
        this.index = -1;
        this.tamanho = 0;
    }

    @Override
    public int indexOf(E o) {
        if (o == null) return -1;
        if (tamanho == 0) return -1;

        for (int i = 0; i < tamanho; i++) {
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
        if (tamanho == 0) return -1;

        for (int i = tamanho -1; i >= 0; i--) {
            Object item = items[i];
            if (o.equals(item)) {
                return i;
            }
        }

        return -1;
    }

    private void copiarArray(Object[] origem, Object[] destino) {
        for (int i = 0; i < origem.length && origem[i] != null; i++) {
            destino[i] = origem[i];
        }
    }

    private void dobrarTamanhoArray() {
        Object[] novoArray = new Object[items.length * 2];
        copiarArray(items, novoArray);
        this.items = novoArray;
    }

    private boolean posicaoValida(int posicao) {
        return posicao >= 0 && posicao < this.tamanho;
    }

    private void garantirEspaco() {
        if (this.tamanho > this.items.length) {
            dobrarTamanhoArray();
        }
    }

    private void compactarItems() {
        Object[] novoArray = new Object[items.length];

        this.index = -1;
        this.tamanho = 0;

        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i] != null) {
                novoArray[++this.index] = this.items[i];
                this.tamanho++;
            }
        }
        this.items = novoArray;
    }

}
