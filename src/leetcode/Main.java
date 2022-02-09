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
                3, 1, 4, 1, 5
        };
        int[] input3 = new int[]{
                2, 4
        };

        // (9 - 1) * (1 + 2)
        System.out.println("output : " + sol.findPairs(input2, 2));
    }
}
