package br.com.fantonio.datastructures.cs14.conjunto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;

public class ConjuntoEspalhamentoTest {

    @Test
    public void primeiroTeste() {
        Conjunto<String> conjunto = new ConjuntoEspalhamento();
        conjunto.adiciona("palavra");
        conjunto.adiciona("computador");
        conjunto.adiciona("apostila");
        conjunto.adiciona("instrutor");
        conjunto.adiciona("mesa");
        conjunto.adiciona("telefone");

        assertThat("Erro: não tem a palavra: apostila", conjunto.contem("apostila"), equalTo(true));

        conjunto.remove("apostila");
        assertThat("Erro: tem a palavra: apostila", conjunto.contem("apostila"), not(equalTo(true)));

        assertThat("Erro: o tamanho do conjunto deveria ser 5", conjunto.tamanho(), equalTo(5));
    }

    @Test
    public void adicionaTest() {
        ConjuntoEspalhamento conjunto = new ConjuntoEspalhamento();
        conjunto.adiciona("Rafael");
        conjunto.adiciona("Ana");
        conjunto.adiciona("Paulo");
        List<String> palavras = conjunto.pegaTodas();

        assertThat(palavras, containsInAnyOrder("Rafael", "Ana", "Paulo"));
    }

    @Test
    public void removeTest() {
        ConjuntoEspalhamento conjunto = new ConjuntoEspalhamento();
        conjunto.adiciona("Rafael");
        conjunto.adiciona("Ana");
        conjunto.adiciona("Paulo");
        List<String> palavras = conjunto.pegaTodas();

        // antes de remover
        assertThat(palavras, containsInAnyOrder("Rafael", "Ana", "Paulo"));
        conjunto.remove("Rafael");

        palavras = conjunto.pegaTodas();

        // depois de remover
        assertThat(palavras, containsInAnyOrder("Ana", "Paulo"));
    }

    @Test
    public void contemTest() {
        ConjuntoEspalhamento conjunto = new ConjuntoEspalhamento();
        assertThat("Erro, nome NÂO deve existir.", conjunto.contem("Felipe"), equalTo(false));

        conjunto.adiciona("Felipe");
        assertThat("Erro, nome DEVE existir.", conjunto.contem("Felipe"), equalTo(true));
    }

    @Test
    public void tamanhoTest() {
        ConjuntoEspalhamento conjunto = new ConjuntoEspalhamento();

        conjunto.adiciona("Felipe");
        assertThat(conjunto.tamanho(), equalTo(1));

        conjunto.adiciona("Felipe");
        assertThat(conjunto.tamanho(), equalTo(1));

        conjunto.adiciona("Renata");
        assertThat(conjunto.tamanho(), equalTo(2));
    }

}
