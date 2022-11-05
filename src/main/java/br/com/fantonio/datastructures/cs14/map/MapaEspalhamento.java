package br.com.fantonio.datastructures.cs14.map;

import java.util.*;

public class MapaEspalhamento<K,V> implements Mapa<K,V> {

    private List<List<Associacao<K,V>>> table = new ArrayList<>();
    private int quantidade = 0;

    public MapaEspalhamento() {
        initHashTable();
    }

    @Override
    public void adiciona(K chave, V valor) {
        List<Associacao<K,V>> associacoes = getLista(chave);

        Optional<Associacao<K, V>> optAssociacao = associacoes.stream()
                .filter(a -> Objects.equals(a.getKey(), chave))
                .findAny();

        if (optAssociacao.isPresent()) {
            this.remove(optAssociacao.get().getKey());
        }

        associacoes.add(new Associacao<>(chave, valor));
        quantidade++;
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

    // TODO Finalizar
    @Override
    public void remove(K chave) {
        quantidade--;
    }

    @Override
    public boolean contemChave(K chave) {
        List<Associacao<K, V>> associacoes = getLista(chave);

        return associacoes.stream()
                .anyMatch(a -> Objects.equals(a.getKey(), chave));
    }

    @Override
    public int quantidade() {
        return this.quantidade;
    }

    private void initHashTable() {
        for (int i = 0; i < 26; i++) {
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

    // Aplicar redimensionamento dinamico
//    private void redimensionaTabela(int novaCapacidade) {
//        List<E> elements = this.pegaTodas();
//        this.table.clear();
//        this.tamanho = 0;
//        for (int i = 0; i < novaCapacidade; i++) {
//            this.table.add(new LinkedList<>());
//        }
//
//        elements.forEach(
//                palavra -> this.adiciona(palavra)
//        );
//    }
//
//    private void verificarCarga() {
//        int capacidade = this.table.size();
//        double carga = (double) this.tamanho / capacidade;
//
//        if (carga > 0.75) {
//            this.redimensionaTabela(capacidade * 2);
//        } else if (carga < 0.25) {
//            this.redimensionaTabela(Math.max(capacidade / 2, 10));
//        }
//    }



}
