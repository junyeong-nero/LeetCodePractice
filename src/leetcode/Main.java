package leetcode;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = new int[]{1, 2, 3, 1};
        int[] arr2 = new int[]{1, 2, 1, 3, 5, 6, 4};
        System.out.println(sol.findPeakElement(arr));
        System.out.println(sol.findPeakElement(arr2));
    }
}
