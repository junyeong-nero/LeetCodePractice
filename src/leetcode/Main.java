package leetcode;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {10, 1, 2, 7, 6, 1, 5};
        int[] arr2 = {2, 5, 2, 1, 2};
        int[] arr3 = {14,6,25,9,30,20,33,34,28,30,16,12,31,9,9,12,34,16,25,32,8,7,30,12,33,20,21,29,24,17,27,34,11,17,30,6,32,21,27,17,16,8,24,12,12,28,11,33,10,32,22,13,34,18,12};
        System.out.println("total : " + sol.combinationSum2(arr, 8));
        System.out.println("total : " + sol.combinationSum2(arr2, 5));
        System.out.println("total : " + sol.combinationSum2(arr3, 27));
    }

}
