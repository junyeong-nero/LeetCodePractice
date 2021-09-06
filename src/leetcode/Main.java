package leetcode;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Solution sol = new Solution();
        // 0,1],[0,2],[2,3],[2,4],[2,5
        int[][] arr = new int[][]{
                {0, 1}, {0, 2}, {2, 3}, {2, 4}, {2, 5}
        };
        int[] a = new int[]{
                -1, 1, 0
        };
        System.out.println(sol.continuousSubarraySum(a, 0));
    }
}
