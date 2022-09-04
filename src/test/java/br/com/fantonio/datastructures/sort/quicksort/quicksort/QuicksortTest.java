package br.com.fantonio.datastructures.sort.quicksort.quicksort;

import br.com.fantonio.datastructures.sort.quicksort.Quicksort;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class QuicksortTest {


    @Test
    public void testWith1() {
        Integer[] array = {2};

        Quicksort qs = new Quicksort();
        qs.sort(array);

        assertThat(array, Matchers.arrayContaining(new Integer[] {2}));
    }

    @Test
    public void testWith2() {
        Integer[] array = {2,0};

        Quicksort qs = new Quicksort();
        qs.sort(array);

        assertThat(array, Matchers.arrayContaining(new Integer[] {0,2}));
    }

    @Test
    public void testWith3() {
        Integer[] array = {2,1,3};

        Quicksort qs = new Quicksort();
        qs.sort(array);

        assertThat(array, Matchers.arrayContaining(new Integer[] {1,2,3}));
    }

    @Test
    public void testWith5() {
        Integer[] array = {2, 4, 5, 3, 1};

        Quicksort qs = new Quicksort();
        qs.sort(array);

        assertThat(array, Matchers.arrayContaining(new Integer[] {1, 2, 3, 4, 5}));
    }

    @Test
    public void testWith10() {
        Integer[] array = {8, 7, 5, 3, 1, 6, 0, 9, 4 ,2};

        Quicksort qs = new Quicksort();
        qs.sort(array);

        assertThat(array, Matchers.arrayContaining(new Integer[] {0, 1, 2, 3, 4, 5, 6 ,7, 8, 9}));
    }


}
