package leetcode;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = new int[]{
                2, -1, 1, 2, 2
        };
        System.out.println(sol.numDecodings("12"));
        System.out.println(sol.numDecodings("226"));
        System.out.println(sol.numDecodings("0"));
        System.out.println(sol.numDecodings("06"));
    }
}
