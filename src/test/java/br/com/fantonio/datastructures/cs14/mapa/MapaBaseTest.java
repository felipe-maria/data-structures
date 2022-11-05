package br.com.fantonio.datastructures.cs14.mapa;

import br.com.fantonio.datastructures.cs14.map.Carro;
import br.com.fantonio.datastructures.cs14.map.Mapa;
import br.com.fantonio.datastructures.cs14.map.MapaLista;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;

// TODO ver se é possível checar os elementos depois da inclusão e remoção pois está dando um falso positivo
/* TODO Verificar se é o possível utilizar o hamcrest para ajudar neste fim, caso não seja, verificar com equals todos
    os elementos dentro da coleção.
 */
public abstract class MapaBaseTest<T extends Mapa<String, Carro>> {

    private T collection;

    protected abstract T createInstance();

    @BeforeEach
    protected void setUp() {
        this.collection = createInstance();
    }

    @Test
    protected void allOperationsTest() {
        Mapa<String, Carro> mapa = this.collection;
        assertThat(mapa.quantidade(), equalTo(0));

        Carro marquinhos = new Carro("Relampago Marquinhos");
        mapa.adiciona("BRA2022", marquinhos);
        Carro matt = new Carro("Matt");
        mapa.adiciona("MAT2022", matt);

        mapa.adiciona("BRA2022", marquinhos);
        assertThat(mapa.quantidade(), equalTo(2));

        Carro mattFromMap = mapa.pega("MAT2022");

        assertThat(mattFromMap, equalTo(matt));
        mapa.remove("MAT2022");
        assertThat(mapa.quantidade(), equalTo(1));
    }


    @Test
    protected void removeNonExistingElementTest() {
        Mapa<String, Carro> mapa = this.collection;
        assertThat(mapa.quantidade(), equalTo(0));
        assertThrows(IllegalArgumentException.class, () -> mapa.pega("BRA2022"));

        mapa.adiciona("BRA2022", new Carro("Relampago Marquinhos"));
        assertThat(mapa.quantidade(), equalTo(1));

        assertThrows(IllegalArgumentException.class, () -> mapa.pega("MATT"));
    }

    @Test
    protected void pegaNonExistingElementTest() {
        Mapa<String, Carro> mapa = this.collection;
        assertThat(mapa.quantidade(), equalTo(0));
        assertThrows(IllegalArgumentException.class, () -> mapa.pega("BRA2022"));

        mapa.adiciona("BRA2022", new Carro("Relampago Marquinhos"));
        assertThat(mapa.quantidade(), equalTo(1));

        assertThrows(IllegalArgumentException.class, () -> mapa.pega("Matt"));
    }

    @Test
    protected void performanceTest() {
        Mapa<String, Carro> mapa = this.collection;

        int numeroDeElementos = 15000;
        long inicio = System.currentTimeMillis();
        for (int i = 0; i < numeroDeElementos; i++) {
            mapa.adiciona("" + i, new Carro("c" + i));
        }
        for (int i = 0; i < numeroDeElementos; i++) {
            mapa.pega("" + i);
        }
        for (int i = 0; i < numeroDeElementos; i++) {
            mapa.contemChave("" + i);
        }
        for (int i = 0; i < numeroDeElementos; i++) {
            mapa.remove("" + i);
        }
        long fim = System.currentTimeMillis();
        System.out.println("Tempo: " + (fim - inicio)/1000.0);
    }


}
