package br.com.fantonio.datastructures.cs14;

public class Aluno {

    private final String nome;

    public Aluno(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public String toString() {
        return this.nome;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;

        Aluno outro = (Aluno) o;

        if (outro.nome != null) {
            if (this.nome != null) {
                return this.nome.equals(outro.nome);
            } else {
                return false;
            }
        } else {
            return false;
        }

    }
}
