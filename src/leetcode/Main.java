package leetcode;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] tmp = new int[][]{
                {1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}
        };
        int[][] tmp2 = new int[][]{
                {1, 2},
                {1, 3}
        };

        System.out.println(sol.findLengthOfLCIS(new int[]{1, 3, 5, 4, 7}));
        System.out.println(sol.findLengthOfLCIS(new int[]{1, 3, 5, 7}));
    }
}
