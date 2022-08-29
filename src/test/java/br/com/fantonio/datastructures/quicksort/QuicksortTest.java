package br.com.fantonio.datastructures.quicksort;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class QuicksortTest {

    @Test
    public void testWith5() {
        Integer[] array = {2, 4, 5, 3, 1};
        Integer[] sortedArray = {1, 2, 3, 4, 5};

        Quicksort qs = new Quicksort();
        qs.sort(array);

        assertThat(array, Matchers.arrayContaining(sortedArray));
    }


}
