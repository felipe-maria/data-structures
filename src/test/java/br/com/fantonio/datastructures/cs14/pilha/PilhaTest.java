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
        pilha.insere(pecaInsere);
        Peca pecaRemovida = pilha.remove();

        assertThat(pilha.vazia(), equalTo(true));
        assertThat(pecaRemovida, equalTo(pecaInsere));
    }

    @Test
    public void pilhaDeAlunoTest() {
        Pilha<String> pilha = new Pilha<String>();
        pilha.insere("Rafael Cosentino");
        pilha.insere("Paulo Silvera");
        String paulo = pilha.remove();
        String rafael = pilha.remove();

        assertThat(paulo, equalTo("Paulo Silvera"));
        assertThat(rafael, equalTo("Rafael Cosentino"));
    }

}
