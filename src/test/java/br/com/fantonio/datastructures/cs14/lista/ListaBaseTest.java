package br.com.fantonio.datastructures.cs14.lista;

import br.com.fantonio.datastructures.cs14.dominio.Aluno;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;

public abstract class ListaBaseTest<T extends Lista<Aluno>> {

    private T implementacao;

    protected abstract T createInstance();

    @BeforeEach
    protected void setUp() {
        this.implementacao = createInstance();
    }

    /**
     * Método auxiliar que extrai de um vetor os nomes do alunos em uma lista.
     *
     * @param lista Lista contendo nomes
     */
    protected List<String> getNomesFromLista(Lista<Aluno> lista) {

        return Arrays.stream(lista.toArray())
                .filter(Objects::nonNull)
                .map(o -> (Aluno) o)
                .map(Aluno::getNome).collect(Collectors.toList());
    }

    /**
     * Adiciona no fim da lista
     */
    @Test
    protected void adicionaNoFimTest() {
        Aluno rafael = new Aluno("Rafael");
        Aluno paulo = new Aluno("Paulo");
        Lista<Aluno> lista = implementacao;
        lista.adiciona(rafael);
        lista.adiciona(paulo);

        List<String> nomes = getNomesFromLista(lista);

        assertThat(nomes.toArray(),
                Matchers.arrayContaining(new String[]{"Rafael", "Paulo"}));
    }

    /**
     * Adiciona no fim da lista acima do tamanho do array - Felipe
     */
    @Test
    protected void adicionaNoFimAcimaTamanhoArrayTest() {
        Lista<Aluno> lista = implementacao;
        for (int i = 1; i<= 101; i++) {
            Aluno aluno = new Aluno(Integer.toString(i));
            lista.adiciona(aluno);
        }

        assertThat(lista.tamanho(), equalTo(101));
    }

    /**
     * Adiciona em uma dada posição
     */
    @Test
    protected void adicionaPorPosicaoTest() {
        Aluno rafael = new Aluno("Rafael");
        Aluno paulo = new Aluno("Paulo");
        Aluno ana = new Aluno("Ana");

        Lista<Aluno> lista = implementacao;
        lista.adiciona(rafael);
        lista.adiciona(0, paulo);
        lista.adiciona(1, ana);


        List<String> nomes = getNomesFromLista(lista);

        assertThat(nomes.toArray(),
                Matchers.arrayContaining(new String[]{"Paulo", "Ana", "Rafael"}));
    }

    /**
     * Adiciona em uma posicao invalida
     */
    @Test
    protected void adicionaPorPosicaoInvalidaTest() {
        Aluno rafael = new Aluno("Rafael");
        Lista<Aluno> lista = implementacao;

        assertThrows(IllegalArgumentException.class, () -> lista.adiciona(101, rafael));
    }

    /**
     * Pegar um aluno por posição
     */
    @Test
    protected void pegaPorPosicaoTest() {
        Aluno rafael = new Aluno("Rafael");
        Aluno paulo = new Aluno("Paulo");
        Lista<Aluno> lista = implementacao;
        lista.adiciona(rafael);
        lista.adiciona(paulo);
        Aluno aluno1 = (Aluno) lista.pega(0);
        Aluno aluno2 = (Aluno) lista.pega(1);

        assertThat(aluno1.getNome(), equalTo("Rafael"));
        assertThat(aluno2.getNome(), equalTo("Paulo"));
    }

    /**
     * Pegar uma posição inválida
     */
    @Test
    protected void pegaPorPosicaoInvalidaTest() {
        Lista<Aluno> lista = implementacao;

        assertThrows(IllegalArgumentException.class, () -> lista.pega(101));
    }


    /**
     * Remover um aluno por posição
     */
    @Test
    protected void removePorPosicaoTest() {
        Aluno rafael = new Aluno("Rafael");
        Aluno paulo = new Aluno("Paulo");
        Lista<Aluno> lista = implementacao;
        lista.adiciona(rafael);
        lista.adiciona(paulo);
        lista.remove(0);

        List<String> nomes = getNomesFromLista(lista);

        assertThat(nomes.toArray(),
                Matchers.arrayContaining(new String[]{"Paulo"}));
        assertThat(lista.tamanho(), equalTo(1));
    }

    @Test
    protected void removePorPosicao2Test() {
        Aluno rafael = new Aluno("Rafael");
        Aluno paulo = new Aluno("Paulo");
        Aluno camila = new Aluno("Camila");
        Lista<Aluno> lista = implementacao;
        lista.adiciona(rafael);
        lista.adiciona(paulo);
        lista.adiciona(camila);
        lista.remove(1);

        List<String> nomes = getNomesFromLista(lista);

        assertThat(nomes.toArray(),
                Matchers.arrayContaining(new String[]{"Rafael", "Camila"}));
        assertThat(lista.tamanho(), equalTo(2));
    }

    @Test
    protected void removeObjetoTest() {
        Aluno rafael = new Aluno("Rafael");
        Aluno paulo = new Aluno("Paulo");
        Aluno ana = new Aluno("Ana");
        Aluno renata = new Aluno("Renata");

        Lista<Aluno> lista = implementacao;
        lista.adiciona(rafael);
        lista.adiciona(paulo);
        lista.adiciona(rafael);
        lista.adiciona(ana);
        lista.adiciona(rafael);
        lista.adiciona(renata);

        lista.remove(rafael);

        List<String> nomes = getNomesFromLista(lista);

        assertThat(nomes.toArray(),
                Matchers.arrayContaining(new String[]{"Paulo", "Ana", "Renata"}));
        assertThat(lista.tamanho(), equalTo(3));
    }

    @Test
    protected void removeObjeto2Test() {
        Aluno rafael = new Aluno("Rafael");
        Aluno paulo = new Aluno("Paulo");
        Aluno ana = new Aluno("Ana");
        Aluno renata = new Aluno("Renata");

        Lista<Aluno> lista = implementacao;
        lista.adiciona(rafael);
        lista.adiciona(paulo);
        lista.adiciona(rafael);
        lista.adiciona(ana);
        lista.adiciona(rafael);
        lista.adiciona(renata);

        lista.remove(paulo);

        List<String> nomes = getNomesFromLista(lista);

        assertThat(nomes.toArray(),
                Matchers.arrayContaining(new String[]{"Rafael","Rafael","Ana","Rafael","Renata"}));
        assertThat(lista.tamanho(), equalTo(5));
    }


    /**
     * Remover um aluno por posição
     */
    @Test
    protected void removePorPosicaoInvalidaTest() {
        Aluno rafael = new Aluno("Rafael");
        Aluno paulo = new Aluno("Paulo");
        Lista<Aluno> lista = implementacao;
        lista.adiciona(rafael);
        lista.adiciona(paulo);
        lista.remove(0);

        List<String> nomes = getNomesFromLista(lista);

        assertThat(nomes.toArray(),
                Matchers.arrayContaining(new String[]{"Paulo"}));
    }

    /**
     * Verificar se a lista contem um dado aluno
     */
    @Test
    protected void contemAlunoTest() {
        Aluno rafael = new Aluno("Rafael");
        Aluno paulo = new Aluno("Paulo");
        Lista<Aluno> lista = implementacao;
        lista.adiciona(rafael);
        lista.adiciona(paulo);
        assertThat(lista.contem(rafael), equalTo(true));
        assertThat(lista.contem(paulo), equalTo(true));
        Aluno ana = new Aluno("Ana");
        assertThat(lista.contem(ana), equalTo(false));
    }

    /**
     * Informar o tamanho da lista
     */
    @Test
    protected void tamanhoListaTest() {
        Aluno a1 = new Aluno("Rafael");
        Aluno a2 = new Aluno("Paulo");
        Aluno a3 = new Aluno("Ana");
        Lista<Aluno> lista = implementacao;
        lista.adiciona(a1);
        lista.adiciona(a2);
        assertThat(lista.tamanho(), equalTo(2));
        lista.adiciona(a3);
        assertThat(lista.tamanho(), equalTo(3));
    }

    @Test
    protected void primeiroIndice() {
        Aluno rafael = new Aluno("Rafael");
        Aluno paulo = new Aluno("Paulo");

        Lista<Aluno> lista = implementacao;
        lista.adiciona(rafael);
        lista.adiciona(paulo);
        lista.adiciona(rafael);

        assertThat(lista.indexOf(rafael), equalTo(0));
    }

    @Test
    protected void primeiroIndiceVetorVazio() {
        Aluno rafael = new Aluno("Rafael");

        Lista<Aluno> lista = implementacao;

        assertThat(lista.indexOf(rafael), equalTo(-1));
    }

    @Test
    protected void ultimoIndiceTest() {
        Aluno rafael = new Aluno("Rafael");
        Aluno paulo = new Aluno("Paulo");

        Lista<Aluno> lista = implementacao;
        lista.adiciona(rafael);
        lista.adiciona(paulo);
        lista.adiciona(rafael);

        assertThat(lista.lastIndexOf(rafael), equalTo(2));
    }

    @Test
    protected void ultimoIndiceVetorVazio() {
        Aluno rafael = new Aluno("Rafael");

        Lista<Aluno> lista = implementacao;

        assertThat(lista.indexOf(rafael), equalTo(-1));
    }

    @Test
    protected void limparTest() {
        Aluno rafael = new Aluno("Rafael");
        Aluno paulo = new Aluno("Paulo");

        Lista<Aluno> lista = implementacao;
        lista.adiciona(rafael);
        lista.adiciona(paulo);

        lista.limpar();

        List<String> nomes = getNomesFromLista(lista);

        assertThat(lista.tamanho(), equalTo(0));
        assertThat(nomes.isEmpty(), equalTo(true));
    }

}
