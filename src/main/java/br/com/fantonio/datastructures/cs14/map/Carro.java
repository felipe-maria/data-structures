package br.com.fantonio.datastructures.cs14.map;

public class Carro {

    private String nome;

    public Carro(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Carro: " + this.nome;
    }

}
