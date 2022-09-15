package br.com.fantonio.datastructures.exercises;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CriptografiaTest {

    @Test
    public void criptografarTest() {
        Criptografia cripto = new Criptografia();

        String frase = "Uma mensagem confidencial";
        String fraseCriptografada = cripto.criptografar(frase);

        assertThat(fraseCriptografada, equalTo("amU megasnem laicnedifnoc"));
    }

    @Test
    public void descriptografarTest() {
        Criptografia cripto = new Criptografia();

        String frase = "amU megasnem laicnedifnoc";
        String fraseDescriptografada = cripto.descriptografar(frase);

        assertThat(fraseDescriptografada, equalTo("Uma mensagem confidencial"));
    }

    @Test
    public void fraseNulaTest() {
        Criptografia cripto = new Criptografia();

        String frase = null;

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                cripto.criptografar(frase)
        );

        assertThat("Frase nula", equalTo(exception.getMessage()));
    }

    @Test
    public void fraseVaziaTest() {
        Criptografia cripto = new Criptografia();

        String frase = "";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                cripto.criptografar(frase)
        );

        assertThat("Frase vazia", equalTo(exception.getMessage()));
    }


}
