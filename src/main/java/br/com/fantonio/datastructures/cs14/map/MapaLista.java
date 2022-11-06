package br.com.fantonio.datastructures.cs14.map;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class MapaLista<K, V> implements Mapa<K, V> {

    private List<Associacao<K, V>> associacoes = new ArrayList<>();
    private int tamanho = 0;

    @Override
    public void adiciona(K chave, V valor) {
        if (this.contemChave(chave)) {
            this.remove(chave);
        }
        Associacao<K, V> associacao = new Associacao<>(chave, valor);
        this.associacoes.add(associacao);
        this.tamanho++;
    }

    @Override
    public V pega(K chave) {
        Associacao<K, V> associacao = this.pegaAssociacao(chave);
        return associacao.getValue();
    }


    @Override
    public void remove(K chave) {
        Associacao<K, V> associacao = this.pegaAssociacao(chave);
        this.associacoes.remove(associacao);
        this.tamanho--;
    }

    @Override
    public boolean contemChave(K chave) {
        return this.associacoes.stream()
                .map(Associacao::getKey)
                .anyMatch(a -> Objects.equals(a,chave));
    }

    @Override
    public int quantidade() {
        return this.tamanho;
    }

    @Override
    public Collection<V> pegaTodos() {

        return this.associacoes.stream()
                .map(Associacao::getValue)
                .collect(Collectors.toList());
    }

    private Associacao<K,V> pegaAssociacao(K chave) {

        return this.associacoes.stream()
                .filter(a -> Objects.equals(a.getKey(), chave))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Chave não existe"));
    }

}
