package leetcode;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] img1 = new int[][]{
                {1, 1, 0, 1, 0, 0, 1, 0, 0, 0},
                {1, 0, 1, 0, 1, 0, 1, 1, 0, 0},
                {1, 1, 0, 1, 0, 0, 1, 0, 0, 0},
                {1, 1, 1, 0, 0, 0, 0, 1, 1, 1},
                {0, 0, 0, 0, 0, 1, 1, 0, 0, 1},
                {0, 1, 1, 1, 0, 0, 0, 1, 1, 0},
                {1, 1, 0, 1, 0, 0, 1, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 1, 1, 0, 0},
                {1, 1, 0, 1, 0, 0, 1, 0, 0, 0},
                {1, 1, 0, 1, 0, 0, 1, 0, 0, 0}
        };
//        System.out.println(sol.largestIsland(img1));
        System.out.println(sol.removeDuplicates("aaraabcccbbnkdn", 2));
    }
}
