package br.com.fantonio.datastructures.exercises;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class BinaryGapTest {

    @Test
    public void test1() {
        BinaryGap bg = new BinaryGap();

        assertThat(bg.solution(1041), equalTo(5));
    }

    @Test
    public void test15() {
        BinaryGap bg = new BinaryGap();

        assertThat(bg.solution(15), equalTo(0));
    }

    @Test
    public void test32() {
        BinaryGap bg = new BinaryGap();

        assertThat(bg.solution(32), equalTo(0));
    }

}
