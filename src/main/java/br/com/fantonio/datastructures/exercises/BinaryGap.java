package br.com.fantonio.datastructures.exercises;

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

public class BinaryGap {
    public int solution(int N) {
        String binary = Integer.toBinaryString(N);

        int maxGap = 0;
        int gap = 0;

        boolean lowBound = false;

        for (int i = 0; i<binary.length(); i++) {
            char value = binary.charAt(i);

            if (value == '1') {
                if (lowBound == false) {
                    lowBound = true;
                }
                if (gap > maxGap) {
                    maxGap = gap;
                }
                gap = 0;
            } else if (lowBound == true) {
                gap++;
            }
        }
        return maxGap;
    }
}
