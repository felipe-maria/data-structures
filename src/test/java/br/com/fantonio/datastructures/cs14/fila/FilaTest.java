package br.com.fantonio.datastructures.cs14.fila;

import br.com.fantonio.datastructures.cs14.dominio.Aluno;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class FilaTest {

    @Test
    public void test() {
        Fila<Aluno> fila = new Fila<>();
        Aluno aluno = new Aluno("João");
        fila.insere(aluno);
        fila.remove();

        assertThat(fila.vazia(), equalTo(true));
    }

    @Test
    public void test2() {
        Fila<String> filaDeString = new Fila<>();
        filaDeString.insere("Rafael Cosentino");
        filaDeString.insere("Paulo Silvera");
        String rafael = filaDeString.remove();
        String paulo = filaDeString.remove();

        assertThat(paulo, equalTo("Paulo Silvera"));
        assertThat(rafael, equalTo("Rafael Cosentino"));
    }

    @Test
    public void exercicio1Test() {
        Fila<Aluno> fila = new Fila<>();
        Aluno aluno = new Aluno("Fulano");
        fila.insere(aluno);
        Aluno alunoRemovido = fila.remove();
        assertThat(aluno, equalTo(alunoRemovido));
        assertThat(fila.vazia(),equalTo(true));
    }


}
