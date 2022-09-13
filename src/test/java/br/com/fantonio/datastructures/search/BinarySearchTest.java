package br.com.fantonio.datastructures.search;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BinarySearchTest extends BaseSearchTest {

    @Override
    protected Search<Integer> createInstance() {
        return new BinarySearch<>();
    }

    @Test
    public void testNullElement() {
        Integer[] numbers = {1, 2, 3};

        Assertions.assertThrows(IllegalArgumentException.class, () -> super.algorithm.search(numbers, null));
    }

}
