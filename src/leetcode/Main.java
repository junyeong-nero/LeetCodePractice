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

        System.out.println(sol.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        System.out.println(sol.lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3}));
        System.out.println(sol.lengthOfLIS(new int[]{7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7}));
    }
}
