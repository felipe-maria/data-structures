package br.com.fantonio.datastructures.cs14.mapa;

import br.com.fantonio.datastructures.cs14.map.Carro;
import br.com.fantonio.datastructures.cs14.map.MapaLista;

public class MapaListaTest extends MapaBaseTest<MapaLista<String, Carro>> {

    @Override
    protected MapaLista<String, Carro> createInstance() {
        return new MapaLista<>();
    }

}
