package leetcode;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.divide(10, 3));
        System.out.println(sol.divide(7, -3));
        System.out.println(sol.divide(1, 1));
        System.out.println(sol.divide(0, 1));
        System.out.println(sol.divide(-2147483648, -1));
        System.out.println(sol.divide(2147483647, -1));
    }

}
