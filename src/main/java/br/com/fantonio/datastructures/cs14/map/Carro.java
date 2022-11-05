package br.com.fantonio.datastructures.cs14.map;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carro carro = (Carro) o;
        return Objects.equals(nome, carro.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }
}
