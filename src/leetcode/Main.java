package leetcode;

import java.util.Arrays;

public class Main {

    public static void solve(int[] arr, int target) {
        Solution sol = new Solution();
        System.out.println(sol.fourSum(arr, target));
    }

    public static void main(String[] args) {
        solve(new int[]{1, 0, -1, 0, -2, 2}, 0);
        solve(new int[]{}, 0);
        solve(new int[]{-2, -1, -1, 1, 1, 2, 2}, 0);
        solve(new int[]{-1,-5,-5,-3,2,5,0,4}, -7);
    }
}
