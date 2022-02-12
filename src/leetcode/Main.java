package leetcode;

import DataStructure.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] input = new int[][]{
                {55, 30, 5, 4, 2},
                {100, 20, 10, 10, 5},
        };
        int[] input2 = new int[]{
                1, -1, 0
        };

        System.out.println("output : " +
                sol.checkInclusion("hello", "ooolleoooleh"));
    }
}
