package leetcode;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {1, 3, 5, 6};
        System.out.println(sol.searchInsert(arr, 5));
        System.out.println(sol.searchInsert(arr, 2));
        System.out.println(sol.searchInsert(arr, 7));
        System.out.println(sol.searchInsert(arr, 0));

        int[] arr2 = {1, 3};
        System.out.println(sol.searchInsert(arr2, 0));
    }

}
