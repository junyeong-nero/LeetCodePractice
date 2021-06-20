package leetcode;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] arr2 = {5, 4, -1, 7, 8};
        int[] arr3 = {-2, -1};
        System.out.println(sol.maxSubArray(arr));
        System.out.println(sol.maxSubArray(arr2));
        System.out.println(sol.maxSubArray(arr3));
        System.out.println(sol.maxSubArray(new int[] {1, -2, 0}));
        System.out.println(sol.maxSubArray(new int[] {0, -3, 1, 1}));
//        System.out.println(sol.solveNQueens(1));
//        System.out.println(sol.solveNQueens(4));
//        System.out.println(sol.solveNQueens(5));
    }
}
