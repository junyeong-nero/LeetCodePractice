package leetcode;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] matrix = new int[][]{
                {20, -21, 14},
                {-19, 4, 19},
                {22, -47, 24},
                {-19, 4, 19}
        };
        int[][] matrix2 = new int[][]{
                {7, 3, 6},
                {1, 4, 5},
                {9, 8, 2},
        };
        int[] arr = new int[]{
                4, -2, 2, -4
        };
        System.out.println(sol.canReorderDoubled(arr));
    }
}
