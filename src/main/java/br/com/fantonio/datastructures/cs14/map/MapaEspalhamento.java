package br.com.fantonio.datastructures.cs14.map;

import java.util.*;
import java.util.stream.Collectors;

public class MapaEspalhamento<K,V> implements Mapa<K,V> {

    private final int DEFAULT_TABLE_SIZE = 128;

    private List<List<Associacao<K,V>>> table = new ArrayList<>();
    private int tamanho = 0;
    private boolean dynamicTable;

    public MapaEspalhamento() {
        initHashTable();
    }

    public MapaEspalhamento(boolean dynamicTable) {
        this.dynamicTable = dynamicTable;
        initHashTable();
    }

    @Override
    public void adiciona(K chave, V valor) {
        adiciona(chave, valor, dynamicTable);
    }

    private void adiciona(K chave, V valor, boolean verificarCarga) {
        if (verificarCarga == true) {
            verificarCarga();
        }

        List<Associacao<K,V>> associacoes = getLista(chave);

        Optional<Associacao<K, V>> optAssociacao = associacoes.stream()
                .filter(a -> Objects.equals(a.getKey(), chave))
                .findAny();

        if (optAssociacao.isPresent()) {
            this.remove(optAssociacao.get().getKey(),false);
        }

        associacoes.add(new Associacao<>(chave, valor));
        tamanho++;
    }

    private void adiciona(Associacao<K,V> associacao) {
        this.adiciona(associacao.getKey(), associacao.getValue(), false);
    }

    @Override
    public V pega(K chave) {
        List<Associacao<K, V>> lista = getLista(chave);

        return lista.stream()
                .filter(a -> Objects.equals(a.getKey(), chave))
                .findAny()
                .map(Associacao::getValue)
                .orElseThrow(() -> new IllegalArgumentException("Elemento não encontrado"));
    }

    @Override
    public void remove(K chave) {
        remove(chave, dynamicTable);
    }

    private void remove(K chave, boolean verificarCarga) {
        if (verificarCarga == true) {
            verificarCarga();
        }
        List<Associacao<K, V>> lista = getLista(chave);

        Associacao<K, V> associacao = lista.stream()
                .filter(a -> Objects.equals(a.getKey(), chave))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Elemento não encontrado"));

        lista.remove(associacao);
        tamanho--;
    }

    @Override
    public boolean contemChave(K chave) {
        List<Associacao<K, V>> associacoes = getLista(chave);

        return associacoes.stream()
                .anyMatch(a -> Objects.equals(a.getKey(), chave));
    }

    @Override
    public int quantidade() {
        return this.tamanho;
    }

    @Override
    public Collection<V> pegaTodos() {
        List<V> allValues = new LinkedList<>();
        for (List<Associacao<K,V>> associacoes : this.table) {
            for (Associacao<K,V> associacao : associacoes) {
                allValues.add(associacao.getValue());
            }
        }

        return allValues;
    }
    
    private Collection<Associacao<K,V>> pegaTodasAssociacoes() {
        
        List<Associacao<K,V>> allAsssociacoes = new LinkedList<>();
        this.table.stream().forEach(
                associacoes -> allAsssociacoes.addAll(
                        associacoes.stream().collect(Collectors.toList())
                )
        );

        return allAsssociacoes;
    }

    private void initHashTable() {
        for (int i = 0; i < DEFAULT_TABLE_SIZE; i++) {
            List<Associacao<K,V>> associacoes = new LinkedList<>();
            this.table.add(associacoes);
        }
    }

    private List<Associacao<K, V>> getLista(K chave) {
        int index = calculateTableIndex(chave);
        return this.table.get(index);
    }

    private int calculateTableIndex(K key) {
        int hashCode = Math.abs(key.hashCode());
        return hashCode % this.table.size();
    }

    private void redimensionaTabela(int novaCapacidade) {
        Collection<Associacao<K,V>> allAssociacoes = this.pegaTodasAssociacoes();
        this.table.clear();
        this.tamanho = 0;
        
        for (int i = 0; i < novaCapacidade; i++) {
            this.table.add(new LinkedList<>());
        }

        allAssociacoes.forEach(
                associacao -> this.adiciona(associacao)
        );
    }

    private void verificarCarga() {

        int capacidade = this.table.size();
        double carga = (double) this.tamanho / capacidade;

        if (carga > 0.75) {
            this.redimensionaTabela(capacidade * 2);
        } else if (carga < 0.25) {
            this.redimensionaTabela(Math.max(capacidade / 2, DEFAULT_TABLE_SIZE));
        }
    }



}
