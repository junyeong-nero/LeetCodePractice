package leetcode;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {3, 2, 2, 3};
        int[] arr2 = {0, 1, 2, 2, 3, 0, 4, 2};
        System.out.println("sol1 : " + Arrays.toString(sol.removeElement(arr, 3)));
        System.out.println("sol1 : " + Arrays.toString(sol.removeElement(arr2, 2)));
    }

}
