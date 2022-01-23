package leetcode;

import DataStructure.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] input = new int[][]{
                {1, 2},
                {4, 5},
                {1, 5},
        };
        int[] input2 = new int[]{
                1, 0, 1, 0, 1, 0, 1
        };
        List<Integer> res = sol.sequentialDigits(1000, 13000);
        System.out.println(res.toString());
    }
}
