package leetcode;

import java.util.Arrays;

public class Main {

    public static void test(int[] input, int result) {
        Solution sol = new Solution();
        if(sol.maxArea(input) == result)
            System.out.println("correct : " + result);
    }

    public static void main(String[] args) {
        test(new int[]{1,8,6,2,5,4,8,3,7}, 49);
        test(new int[]{4,3,2,1,4}, 16);
        test(new int[]{1,1}, 1);
        test(new int[]{1, 2, 1}, 2);
    }
}
