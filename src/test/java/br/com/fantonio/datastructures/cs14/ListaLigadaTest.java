package br.com.fantonio.datastructures.cs14;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

public class ListaLigadaTest extends ListaBaseTest<ListaLigada<Aluno>> {

    @Override
    protected ListaLigada<Aluno> createInstance() {
        return new ListaLigada<>();
    }

    @Test
    public void adicionaNoComecoTest() {
        ListaLigada<Aluno> lista = new ListaLigada<>();
        lista.adicionaNoComeco("Rafael");
        lista.adicionaNoComeco("Paulo");

        List<String> nomes = super.getNomesFromLista(lista);

        assertThat(nomes.toArray(),
                Matchers.arrayContaining(new String[]{"Paulo", "Rafael"}));
    }

    @Test
    public void removeDoComecoTest() {
        ListaLigada<Aluno> lista = new ListaLigada<>();
        lista.adiciona(new Aluno("Rafael"));
        lista.adiciona(new Aluno("Paulo"));
        lista.removeDoComeco();

        List<String> nomes = super.getNomesFromLista(lista);

        assertThat(nomes.toArray(),
                Matchers.arrayContaining(new String[]{"Paulo"}));
    }

    @Test
    public void removeDoFimTest() {
        ListaLigada<Aluno> lista = new ListaLigada<>();
        lista.adiciona(new Aluno("Rafael"));
        lista.adiciona(new Aluno("Paulo"));
        lista.removeDoFim();

        List<String> nomes = super.getNomesFromLista(lista);

        assertThat(nomes.toArray(),
                Matchers.arrayContaining(new String[]{"Rafael"}));
    }

}
