package br.com.fantonio.datastructures.sort.quicksort;

import br.com.fantonio.datastructures.sort.SortBaseTest;
import br.com.fantonio.datastructures.sort.quicksort.Quicksort;

public class QuicksortTest extends SortBaseTest<Quicksort> {

    @Override
    protected Quicksort createInstance() {
        return new Quicksort();
    }
}
