package br.com.fantonio.datastructures.cs14.pilha;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class MinotauroTest {

    @Test
    public void mapa2x2_1PassoTest() {
        boolean[][] mapa = {
                {true, true},
                {true, true}
        };

        Minotauro minotauro = new Minotauro(mapa);

        int passos = minotauro.fugir();
        assertThat(passos, equalTo(1));
    }

    @Test
    public void mapa2x2_2PassosTest() {
        boolean[][] mapa = {
                {true, false},
                {true, true}
        };

        Minotauro minotauro = new Minotauro(mapa);

        int passos = minotauro.fugir();
        assertThat(passos, equalTo(2));
    }

    @Test
    public void mapa2x2_0PassosTest() {
        boolean[][] mapa = {
                {true, false},
                {false, true}
        };

        Minotauro minotauro = new Minotauro(mapa);
        int passos = minotauro.fugir();

        assertThat(passos, equalTo(0));
    }

    @Test
    public void mapa4x4_6PassosTest() {
        boolean[][] mapa = {
                {true, true, true, false},
                {true, false, true, false},
                {true, false, false, false},
                {true, true, true, true}
        };

        Minotauro minotauro = new Minotauro(mapa);

        int passos = minotauro.fugir();
        assertThat(passos, equalTo(6));
    }

    @Test
    public void mapa4x4_5PassosTest(){
        boolean[][] mapa = {
                {true,true,false,false},
                {false,true,true,false},
                {false,false,true,true},
                {false,false,true,true}
        };

        Minotauro minotauro = new Minotauro(mapa);

        int passos = minotauro.fugir();
        assertThat(passos, equalTo(5));


    }


}


