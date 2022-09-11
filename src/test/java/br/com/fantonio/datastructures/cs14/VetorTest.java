package br.com.fantonio.datastructures.cs14;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class VetorTest {

    /**
     * Método auxiliar que extrai de um vetor os nomes do alunos em uma lista.
     *
     * @param lista Lista contendo nomes
     */
    private List<String> getNomesFromVetor(Vetor<Aluno> lista) {
        return Arrays.stream(lista.toArray())
                .filter(Objects::nonNull)
                .map(o -> (Aluno) o)
                .map(Aluno::getNome).collect(Collectors.toList());
    }

    /**
     * Adiciona no fim da lista
     */
    @Test
    public void adicionaNoFimTest() {
        Aluno rafael = new Aluno("Rafael");
        Aluno paulo = new Aluno("Paulo");
        Vetor<Aluno> lista = new Vetor<>();
        lista.adiciona(rafael);
        lista.adiciona(paulo);

        List<String> nomes = getNomesFromVetor(lista);

        assertThat(nomes.toArray(),
                Matchers.arrayContaining(new String[]{"Rafael", "Paulo"}));
    }

    /**
     * Adiciona no fim da lista acima do tamanho do array - Felipe
     */
    @Test
    public void adicionaNoFimAcimaTamanhoArrayTest() {
        Vetor<Aluno> lista = new Vetor<>();
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
    public void adicionaPorPosicaoTest() {
        Aluno rafael = new Aluno("Rafael");
        Aluno paulo = new Aluno("Paulo");
        Aluno ana = new Aluno("Ana");

        Vetor<Aluno> lista = new Vetor<>();
        lista.adiciona(rafael);
        lista.adiciona(0, paulo);
        lista.adiciona(1, ana);


        List<String> nomes = getNomesFromVetor(lista);

        assertThat(nomes.toArray(),
                Matchers.arrayContaining(new String[]{"Paulo", "Ana", "Rafael"}));
    }

    /**
     * Adiciona em uma posicao invalida
     */
    @Test
    public void adicionaPorPosicaoInvalidaTest() {
        Aluno rafael = new Aluno("Rafael");
        Vetor<Aluno> lista = new Vetor<>();

        assertThrows(IllegalArgumentException.class, () -> lista.adiciona(101, rafael));
    }

    /**
     * Pegar um aluno por posição
     */
    @Test
    public void pegaPorPosicaoTest() {
        Aluno rafael = new Aluno("Rafael");
        Aluno paulo = new Aluno("Paulo");
        Vetor<Aluno> lista = new Vetor<>();
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
    public void pegaPorPosicaoInvalidaTest() {
        Vetor<Aluno> lista = new Vetor<>();

        assertThrows(IllegalArgumentException.class, () -> lista.pega(101));
    }


    /**
     * Remover um aluno por posição
     */
    @Test
    public void removePorPosicaoTest() {
        Aluno rafael = new Aluno("Rafael");
        Aluno paulo = new Aluno("Paulo");
        Vetor<Aluno> lista = new Vetor<>();
        lista.adiciona(rafael);
        lista.adiciona(paulo);
        lista.remove(0);

        List<String> nomes = getNomesFromVetor(lista);

        assertThat(nomes.toArray(),
                Matchers.arrayContaining(new String[]{"Paulo"}));
        assertThat(lista.tamanho(), equalTo(1));
    }

    @Test
    public void removeObjetoTest() {
        Aluno rafael = new Aluno("Rafael");
        Aluno paulo = new Aluno("Paulo");
        Aluno ana = new Aluno("Ana");
        Aluno renata = new Aluno("Renata");

        Vetor<Aluno> lista = new Vetor<>();
        lista.adiciona(rafael);
        lista.adiciona(paulo);
        lista.adiciona(rafael);
        lista.adiciona(ana);
        lista.adiciona(rafael);
        lista.adiciona(renata);

        lista.remove(rafael);

        List<String> nomes = getNomesFromVetor(lista);

        assertThat(nomes.toArray(),
                Matchers.arrayContaining(new String[]{"Paulo", "Ana", "Renata"}));
        assertThat(lista.tamanho(), equalTo(3));
    }

    @Test
    public void removeObjeto2Test() {
        Aluno rafael = new Aluno("Rafael");
        Aluno paulo = new Aluno("Paulo");
        Aluno ana = new Aluno("Ana");
        Aluno renata = new Aluno("Renata");

        Vetor<Aluno> lista = new Vetor<>();
        lista.adiciona(rafael);
        lista.adiciona(paulo);
        lista.adiciona(rafael);
        lista.adiciona(ana);
        lista.adiciona(rafael);
        lista.adiciona(renata);

        lista.remove(paulo);

        List<String> nomes = getNomesFromVetor(lista);

        assertThat(nomes.toArray(),
                Matchers.arrayContaining(new String[]{"Rafael","Rafael","Ana","Rafael","Renata"}));
        assertThat(lista.tamanho(), equalTo(5));
    }


    /**
     * Remover um aluno por posição
     */
    @Test
    public void removePorPosicaoInvalidaTest() {
        Aluno rafael = new Aluno("Rafael");
        Aluno paulo = new Aluno("Paulo");
        Vetor<Aluno> lista = new Vetor<>();
        lista.adiciona(rafael);
        lista.adiciona(paulo);
        lista.remove(0);

        List<String> nomes = getNomesFromVetor(lista);

        assertThat(nomes.toArray(),
                Matchers.arrayContaining(new String[]{"Paulo"}));
    }

    /**
     * Verificar se a lista contem um dado aluno
     */
    @Test
    public void contemAlunoTest() {
        Aluno rafael = new Aluno("Rafael");
        Aluno paulo = new Aluno("Paulo");
        Vetor<Aluno> lista = new Vetor<>();
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
    public void tamanhoListaTest() {
        Aluno a1 = new Aluno("Rafael");
        Aluno a2 = new Aluno("Paulo");
        Aluno a3 = new Aluno("Ana");
        Vetor<Aluno> lista = new Vetor<>();
        lista.adiciona(a1);
        lista.adiciona(a2);
        assertThat(lista.tamanho(), equalTo(2));
        lista.adiciona(a3);
        assertThat(lista.tamanho(), equalTo(3));
    }

    @Test
    public void primeiroIndice() {
        Aluno rafael = new Aluno("Rafael");
        Aluno paulo = new Aluno("Paulo");

        Vetor<Aluno> lista = new Vetor<>();
        lista.adiciona(rafael);
        lista.adiciona(paulo);
        lista.adiciona(rafael);

        assertThat(lista.indexOf(rafael), equalTo(0));
    }

    @Test
    public void primeiroIndiceVetorVazio() {
        Aluno rafael = new Aluno("Rafael");

        Vetor<Aluno> lista = new Vetor<>();

        assertThat(lista.indexOf(rafael), equalTo(-1));
    }

    @Test
    public void ultimoIndiceTest() {
        Aluno rafael = new Aluno("Rafael");
        Aluno paulo = new Aluno("Paulo");

        Vetor<Aluno> lista = new Vetor<>();
        lista.adiciona(rafael);
        lista.adiciona(paulo);
        lista.adiciona(rafael);

        assertThat(lista.lastIndexOf(rafael), equalTo(2));
    }

    @Test
    public void ultimoIndiceVetorVazio() {
        Aluno rafael = new Aluno("Rafael");

        Vetor<Aluno> lista = new Vetor<>();

        assertThat(lista.indexOf(rafael), equalTo(-1));
    }

}
