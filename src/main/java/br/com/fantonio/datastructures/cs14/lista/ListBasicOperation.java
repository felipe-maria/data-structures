package br.com.fantonio.datastructures.cs14.lista;

public class ListBasicOperation<E> {

    public E[] dobrarTamanhoArray(E[] elements) {
        E[] newArray = (E[]) new Object[elements.length * 2];
        copiarArray(elements, newArray);

        return newArray;
    }

    public void copiarArray(E[] origem, E[] destino) {
        for (int i = 0; i < origem.length && origem[i] != null; i++) {
            destino[i] = origem[i];
        }
    }

}
