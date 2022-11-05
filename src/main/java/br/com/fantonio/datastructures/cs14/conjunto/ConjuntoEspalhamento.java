package br.com.fantonio.datastructures.cs14.conjunto;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ConjuntoEspalhamento<E> implements Conjunto<E> {

    private int tamanho = 0;
    private List<List<E>> table = new ArrayList<>();

    public ConjuntoEspalhamento() {
        initHashTable();
    }

    @Override
    public void adiciona(E element) {
        if (!this.contem(element)){
            this.verificarCarga();
            List<E> lista = getList(element);
            lista.add(element);
            tamanho++;
        }
    }

    @Override
    public void remove(E element) {
        if (this.contem(element)) {
            this.verificarCarga();
            List<E> lista = getList(element);
            lista.remove(element);
            tamanho--;
        }
    }

    @Override
    public boolean contem(E element) {
        List<E> lista = getList(element);

        return lista.contains(element);
    }

    @Override
    public List<E> pegaTodas() {
        List<E> allElements = new LinkedList<>();
        this.table.forEach(
                list -> allElements.addAll(list)
        );

        return allElements;
    }

    @Override
    public int tamanho() {
        return tamanho;
    }

    private List<E> getList(E element) {
        int index = this.calculateTableIndex(element);
        return this.table.get(index);
    }

    private void initHashTable() {
        for (int i = 0; i < 26; i++) {
            List<E> list = new LinkedList<>();
            this.table.add(list);
        }
    }

    private int calculateTableIndex(E element) {
        int codigoDeEspalhamento = Math.abs(element.hashCode());
        return codigoDeEspalhamento % this.table.size();
    }

    private void redimensionaTabela(int novaCapacidade) {
        List<E> elements = this.pegaTodas();
        this.table.clear();
        this.tamanho = 0;
        for (int i = 0; i < novaCapacidade; i++) {
            this.table.add(new LinkedList<>());
        }

        elements.forEach(
                palavra -> this.adiciona(palavra)
        );
    }

    private void verificarCarga() {
        int capacidade = this.table.size();
        double carga = (double) this.tamanho / capacidade;

        if (carga > 0.75) {
            this.redimensionaTabela(capacidade * 2);
        } else if (carga < 0.25) {
            this.redimensionaTabela(Math.max(capacidade / 2, 10));
        }
    }

}
