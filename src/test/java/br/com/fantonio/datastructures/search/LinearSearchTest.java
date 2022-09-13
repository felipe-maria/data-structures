package br.com.fantonio.datastructures.search;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class LinearSearchTest extends BaseSearchTest{

    @Override
    protected Search<Integer> createInstance() {
        return new LinearSearch<>();
    }

    @Test
    public void searchInAnArraySize10Unordered() {
        Integer[] numbers = {4,2,7,5,9,1,10,6,3,8};

        assertThat(algorithm.search(numbers, 8), equalTo(9));
    }
}
