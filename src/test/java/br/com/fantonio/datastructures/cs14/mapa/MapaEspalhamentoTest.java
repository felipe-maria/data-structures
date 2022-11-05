package br.com.fantonio.datastructures.cs14.mapa;

import br.com.fantonio.datastructures.cs14.map.Carro;
import br.com.fantonio.datastructures.cs14.map.MapaEspalhamento;

public class MapaEspalhamentoTest extends MapaBaseTest<MapaEspalhamento<String, Carro>> {

    @Override
    protected MapaEspalhamento<String, Carro> createInstance() {
        return new MapaEspalhamento<>();
    }

}
