package leetcode;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {1, 2, 0};
        int[] arr2 = {3, 4, -1, 1};
        int[] arr3 = {7, 8, 9, 10, 11, 12};
        int[] arr4 = {0, 2, 2, 1, 1};
        System.out.println("sol1 : " + sol.firstMissingPositive(arr));
        System.out.println("sol1 : " + sol.firstMissingPositive(arr2));
        System.out.println("sol1 : " + sol.firstMissingPositive(arr3));
        System.out.println("sol1 : " + sol.firstMissingPositive(arr4));
    }

}
