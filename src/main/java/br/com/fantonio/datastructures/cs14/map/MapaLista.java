package br.com.fantonio.datastructures.cs14.map;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MapaLista<K, V> implements Mapa<K, V> {

    private List<Associacao<K, V>> associacoes = new ArrayList<>();
    private int tamanho = 0;

    @Override
    public void adiciona(K chave, V valor) {
        if (this.existe(chave)) {
            this.remove(chave);
        }
        Associacao<K, V> associacao = new Associacao<>(chave, valor);
        this.associacoes.add(associacao);
        this.tamanho++;
    }

    @Override
    public V pega(K chave) {
        Associacao<K, V> associacao = this.pegaAssociacao(chave);
        if (associacao != null) {
            return associacao.getValue();
        }
        return null;
    }


    @Override
    public void remove(K chave) {
        Associacao<K, V> associacao = this.pegaAssociacao(chave);
        if (associacao != null) {
            this.associacoes.remove(associacao);
            this.tamanho--;
        }
    }

    @Override
    public boolean existe(K chave) {
        return this.associacoes.stream()
                .map(Associacao::getKey)
                .anyMatch(a -> Objects.equals(a,chave));
    }

    @Override
    public int quantidade() {
        return this.tamanho;
    }

    private Associacao<K,V> pegaAssociacao(K chave) {

        return this.associacoes.stream()
                .filter(a -> Objects.equals(a.getKey(), chave))
                .findAny()
                .orElse(null);
    }

}
