package br.com.fantonio.datastructures.search;

public class BinarySearchTest extends BaseSearchTest {

    @Override
    protected Search<Integer> createInstance() {
        return new BinarySearch<>();
    }

}
