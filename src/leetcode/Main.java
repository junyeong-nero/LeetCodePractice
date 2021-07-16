package leetcode;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = new int[]{2, 2, 3, 4};
        int[] arr2 = new int[]{4, 2, 3, 4};
        System.out.println(sol.triangleNumber(arr));
        System.out.println(sol.triangleNumber(arr2));
    }
}
