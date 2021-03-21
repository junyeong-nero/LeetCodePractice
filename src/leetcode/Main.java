package leetcode;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.longestCommonPrefix(new String[]{"flower", "flow", "flip"}));
        System.out.println(sol.longestCommonPrefix(new String[]{"cir", "car"}));
        System.out.println(sol.longestCommonPrefix(new String[]{"flower"}));
    }
}
