package leetcode;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int[] arr2 = {4, 2, 0, 3, 2, 5};
        int[] arr3 = {4, 2, 3};
        System.out.println("total : " + sol.trap(arr));
        System.out.println("total : " + sol.trap(arr2));
        System.out.println("total : " + sol.trap(arr3));
    }

}
