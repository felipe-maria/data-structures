package br.com.fantonio.datastructures.cs14.lista;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

public class ListaDuplamenteLigadaTest extends ListaBaseTest<ListaDuplamenteLigada<Aluno>> {

    @Override
    protected ListaDuplamenteLigada<Aluno> createInstance() {
        return new ListaDuplamenteLigada<>();
    }

    @Test
    public void adicionaNoComecoTest() {
        ListaDuplamenteLigada<Aluno> lista = new ListaDuplamenteLigada<>();
        lista.adicionaNoComeco(new Aluno("Rafael"));
        lista.adicionaNoComeco(new Aluno("Paulo"));

        List<String> nomes = super.getNomesFromLista(lista);

        assertThat(nomes.toArray(),
                Matchers.arrayContaining(new String[]{"Paulo", "Rafael"}));
    }

    @Test
    public void removeDoComecoTest() {
        ListaDuplamenteLigada<Aluno> lista = new ListaDuplamenteLigada<>();
        lista.adiciona(new Aluno("Rafael"));
        lista.adiciona(new Aluno("Paulo"));
        lista.removeDoComeco();

        List<String> nomes = super.getNomesFromLista(lista);

        assertThat(nomes.toArray(),
                Matchers.arrayContaining(new String[]{"Paulo"}));
    }

    @Test
    public void removeDoFimTest() {
        ListaDuplamenteLigada<Aluno> lista = new ListaDuplamenteLigada<>();
        lista.adiciona(new Aluno("Rafael"));
        lista.adiciona(new Aluno("Paulo"));
        lista.removeDoFim();

        List<String> nomes = super.getNomesFromLista(lista);

        assertThat(nomes.toArray(),
                Matchers.arrayContaining(new String[]{"Rafael"}));
    }

}
