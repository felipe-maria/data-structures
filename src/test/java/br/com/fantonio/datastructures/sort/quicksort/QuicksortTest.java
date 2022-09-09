package br.com.fantonio.datastructures.sort.quicksort;

import br.com.fantonio.datastructures.sort.SortBaseTest;

public class QuicksortTest extends SortBaseTest<Quicksort> {

    @Override
    protected Quicksort createInstance() {
        return new Quicksort();
    }
}
