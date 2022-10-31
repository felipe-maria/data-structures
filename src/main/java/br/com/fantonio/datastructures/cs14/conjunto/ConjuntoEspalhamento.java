package br.com.fantonio.datastructures.cs14.conjunto;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ConjuntoEspalhamento implements Conjunto<String> {

    private int tamanho = 0;

    private List<List<String>> tabela = new ArrayList<List<String>>();

    public ConjuntoEspalhamento() {
        inicializaTabelaEspalhamento();
    }

    @Override
    public void adiciona(String palavra) {
        if (!this.contem(palavra)){
            this.verificarCarga();
            List<String> lista = pegaLista(palavra);
            lista.add(palavra);
            tamanho++;
        }
    }

    @Override
    public void remove(String palavra) {
        if (this.contem(palavra)) {
            this.verificarCarga();
            List<String> lista = pegaLista(palavra);
            lista.remove(palavra);
            tamanho--;
        }
    }

    @Override
    public boolean contem(String palavra) {
        List<String> lista = pegaLista(palavra);

        return lista.contains(palavra);
    }

    @Override
    public List<String> pegaTodas() {
        List<String> todasAsPalavras = new LinkedList<>();
        for (List<String> lista : this.tabela) {
            todasAsPalavras.addAll(lista);
        }

        return todasAsPalavras;
    }

    @Override
    public int tamanho() {
        return tamanho;
    }

    private List<String> pegaLista(String palavra) {
        int indice = this.calculaIndiceDaTabela(palavra);
        return this.tabela.get(indice);
    }

    private void inicializaTabelaEspalhamento() {
        for (int i = 0; i < 26; i++) {
            List<String> lista = new LinkedList<>();
            this.tabela.add(lista);
        }
    }

    private int calculaIndiceDaTabela(String palavra) {
        int codigoDeEspalhamento = Math.abs(this.calculaCodigoDeEspalhamento(palavra));
        return codigoDeEspalhamento % this.tabela.size();
    }

    private int calculaCodigoDeEspalhamento(String palavra) {
        int codigo = 1;
        for (int i = 0; i < palavra.length(); i++) {
            codigo = 31 * codigo + palavra.charAt(i);
        }

        return codigo;
    }

    private void redimensionaTabela(int novaCapacidade) {
        List<String> palavras = this.pegaTodas();
        this.tabela.clear();
        this.tamanho = 0;
        for (int i = 0; i < novaCapacidade; i++) {
            this.tabela.add(new LinkedList<>());
        }

        palavras.forEach(
                palavra -> this.adiciona(palavra)
        );
    }

    private void verificarCarga() {
        int capacidade = this.tabela.size();
        double carga = (double) this.tamanho / capacidade;

        if (carga > 0.75) {
            this.redimensionaTabela(capacidade * 2);
        } else if (carga < 0.25) {
            this.redimensionaTabela(Math.max(capacidade / 2, 10));
        }
    }


}
