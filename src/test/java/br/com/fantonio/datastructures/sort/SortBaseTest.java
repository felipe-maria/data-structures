package br.com.fantonio.datastructures.sort;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Inspired by this question on Stackoverflow:
 *
 * https://stackoverflow.com/questions/16237135/writing-a-single-unit-test-for-multiple-implementations-of-an-interface
 * @param <T>
 */
public abstract class SortBaseTest<T extends Sort> {

    private T sortAlgorithm;

    protected abstract T createInstance();

    @BeforeEach
    public void setUp(){
        this.sortAlgorithm = createInstance();
    }

    @Test
    public void testWith1() {
        Integer[] array = {2};

        this.sortAlgorithm.sort(array);

        assertThat(array, Matchers.arrayContaining(new Integer[] {2}));
    }

    @Test
    public void testWith2() {
        Integer[] array = {2,0};

        this.sortAlgorithm.sort(array);

        assertThat(array, Matchers.arrayContaining(new Integer[] {0,2}));
    }

    @Test
    public void testWith3() {
        Integer[] array = {2,1,3};

        this.sortAlgorithm.sort(array);

        assertThat(array, Matchers.arrayContaining(new Integer[] {1,2,3}));
    }

    @Test
    public void testWith5() {
        Integer[] array = {2, 4, 5, 3, 1};

        this.sortAlgorithm.sort(array);

        assertThat(array, Matchers.arrayContaining(new Integer[] {1, 2, 3, 4, 5}));
    }

    @Test
    public void testWith10() {
        Integer[] array = {8, 7, 5, 3, 1, 6, 0, 9, 4 ,2};

        this.sortAlgorithm.sort(array);

        assertThat(array, Matchers.arrayContaining(new Integer[] {0, 1, 2, 3, 4, 5, 6 ,7, 8, 9}));
    }

    public void testWith100() {

        Integer[] array = { 40,74,23,38,15,46,57,18,79,76,80,89,70,98,5,100,97,8,99,20,84,58,3,24,81,33,27,28,55,63,65
                ,32,26,34,85,96,37,4,39,1,41,30,93,44,95,6,67,48,49,54,35,52,53,50,29,90,7,22,59,60,61,92,42,64,31,66
                ,47,14,69,13,71,72,94,2,75,10,77,78,9,11,25,82,83,21,51,86,87,88,12,56,91,62,43,73,45,36,17,68,19,16};

        this.sortAlgorithm.sort(array);

        assertThat(array, Matchers.arrayContaining(new Integer[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21
                ,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55
                ,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89
                ,90,91,92,93,94,95,96,97,98,99,100}));
    }

}
