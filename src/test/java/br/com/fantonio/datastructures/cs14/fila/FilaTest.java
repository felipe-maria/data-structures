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


}
