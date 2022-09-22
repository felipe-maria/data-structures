package br.com.fantonio.datastructures.cs14.lista;

import br.com.fantonio.datastructures.cs14.dominio.Aluno;

public class VetorTest extends ListaBaseTest<Vetor<Aluno>>{

    @Override
    protected Vetor<Aluno> createInstance() {
        return new Vetor<>();
    }
}
