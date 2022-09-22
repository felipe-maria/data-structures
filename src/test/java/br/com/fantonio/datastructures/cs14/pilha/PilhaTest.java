package br.com.fantonio.datastructures.cs14.pilha;

import br.com.fantonio.datastructures.cs14.dominio.Peca;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class PilhaTest {

    /**
     * Verifica se a Pilha está vazia
     */
    @Test
    public void pilhaVaziaTest() {
        Pilha<Peca> pilha = new Pilha<>();
        Peca pecaInsere = new Peca();
        pilha.push(pecaInsere);
        Peca pecaRemovida = pilha.pop();

        assertThat(pilha.empty(), equalTo(true));
        assertThat(pecaRemovida, equalTo(pecaInsere));
    }

    @Test
    public void pilhaDeAlunoTest() {
        Pilha<String> pilha = new Pilha<String>();
        pilha.push("Rafael Cosentino");
        pilha.push("Paulo Silvera");
        String paulo = pilha.pop();
        String rafael = pilha.pop();

        assertThat(paulo, equalTo("Paulo Silvera"));
        assertThat(rafael, equalTo("Rafael Cosentino"));
    }

    @Test
    public void pilhaPeekTest() {
        Pilha<String> pilha = new Pilha<String>();
        pilha.push("Paulo Silvera");
        String paulo = pilha.peek();

        assertThat(paulo, equalTo("Paulo Silvera"));
        assertThat(pilha.empty(), equalTo(false));
    }

}
