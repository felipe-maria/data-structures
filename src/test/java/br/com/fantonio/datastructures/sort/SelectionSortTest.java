package br.com.fantonio.datastructures.sort;

import br.com.fantonio.datastructures.sort.SelectionSort;
import br.com.fantonio.datastructures.sort.SortBaseTest;

public class SelectionSortTest extends SortBaseTest<SelectionSort> {

    @Override
    protected SelectionSort createInstance() {
        return new SelectionSort();
    }
}
