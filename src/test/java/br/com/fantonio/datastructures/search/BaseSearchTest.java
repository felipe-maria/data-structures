package br.com.fantonio.datastructures.search;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;

public abstract class BaseSearchTest {

    protected Search<Integer> algorithm;

    protected abstract Search<Integer> createInstance();

    @BeforeEach
    public void setUp() {
        algorithm = createInstance();
    }

    /**
     * Test on a null array
     */
    @Test
    public void searchInAnArrayNull(){
        Integer[] numbers = null;

        assertThrows(IllegalArgumentException.class, () -> algorithm.search(numbers, 1));
    }

    /**
     * Test on a empty array
     */
    @Test
    public void searchInAnEmptyArray() {
        Integer[] numbers = {};

        assertThrows(IllegalArgumentException.class, () -> algorithm.search(numbers, null));
    }

    /**
     * Test on N=1
     */
    @Test
    public void searchInAnArraySize1() {
        Integer[] numbers = {1};

        assertThat(algorithm.search(numbers, 1), equalTo(0));
    }

    /**
     * Test on N=2
     */
    @Test
    public void searchInAnArraySize2() {
        Integer[] numbers = {1,2};

        assertThat(algorithm.search(numbers, 2), equalTo(1));
    }

    /**
     * Test on N=3
     */
    @Test
    public void searchInAnArraySize3() {
        Integer[] numbers = {1,2,3};

        assertThat(algorithm.search(numbers, 2), equalTo(1));
    }

    /**
     * Test on N=5
     */
    @Test
    public void searchInAnArraySize10() {
        Integer[] numbers = {1,2,3,4,5,6,7,8,9,10};

        assertThat(algorithm.search(numbers, 5), equalTo(4));
    }

}
