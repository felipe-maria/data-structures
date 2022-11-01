package br.com.fantonio.datastructures.cs14.mapa;

import br.com.fantonio.datastructures.cs14.map.Carro;
import br.com.fantonio.datastructures.cs14.map.Mapa;
import br.com.fantonio.datastructures.cs14.map.MapaLista;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class MapaTest {

    @Test
    public void adicionarTest() {
        Mapa<String, Carro> mapa = new MapaLista<>();
        assertThat(mapa.quantidade(), equalTo(0));

        Carro carro = new Carro("Relampago Marquinhos");
        mapa.adiciona("BRA2022", carro);

        assertThat(mapa.quantidade(), equalTo(1));
    }

    @Test
    public void removerTest() {

    }

    @Test
    public void pegarTest() {

    }

    @Test
    public void existeTest() {

    }

    @Test
    public void quantidadeTest() {

    }

    @Test
    public void operacoesCombinadasTest() {

    }



}
