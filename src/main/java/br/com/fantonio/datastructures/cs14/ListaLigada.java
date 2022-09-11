package br.com.fantonio.datastructures.cs14;

public class ListaLigada<E> implements Lista<E> {

    private Celula primeira;
    private Celula ultima;

    @Override
    public void adiciona(E element) {
        if (primeira == null) {
            Celula celula = new Celula(element);
            primeira = celula;
            ultima = celula;
        } else {
            Celula novaUltima = new Celula(element);
            ultima.setProxima(novaUltima);
            ultima = novaUltima;
        }
    }

    @Override
    public void adiciona(int posicao, E element) throws IllegalArgumentException {
        // TODO Implement it
    }

    @Override
    public Object pega(int posicao) throws IllegalArgumentException {
        return null;
    }

    @Override
    public void remove(int posicao) {
        // TODO Implement it
    }

    @Override
    public void remove(E item) {
        // TODO Implement it
    }

    @Override
    public boolean contem(E item) {
        return false;
    }

    @Override
    public int tamanho() {
        return 0;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[10];
        Celula proxima = primeira;
        int indice = -1;
        int tamanho = 0;
        while (proxima != null) {
            if (indice == array.length-1) {
                array = dobrarTamanhoArray(array);
            }
            array[++indice] = proxima.getElemento();
            proxima = proxima.getProxima();
            tamanho++;
        }
        return array;
    }

    private Object[] dobrarTamanhoArray(Object[] elements) {
        Object[] newArray = new Object[elements.length * 2];
        copiarArray(elements, newArray);

        return newArray;
    }

    private void copiarArray(Object[] origem, Object[] destino) {
        for (int i = 0; i < origem.length && origem[i] != null; i++) {
            destino[i] = origem[i];
        }
    }

    @Override
    public void limpar() {
        // TODO Implement it
    }

    @Override
    public int indexOf(E o) {
        return 0;
    }

    @Override
    public int lastIndexOf(E o) {
        return 0;
    }

    public void adicionaNoComeco(Object elemento) {
        // TODO Implement it
    }

    public void removeDoComeco() {
        // TODO Implement it
    }

    public void removeDoFim() {
        // TODO Implement it
    }
}
