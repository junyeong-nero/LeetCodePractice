package leetcode;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.longestValidParentheses("(()"));
        System.out.println(sol.longestValidParentheses("()(()"));
        System.out.println(sol.longestValidParentheses("(())("));
        System.out.println(sol.longestValidParentheses("(()()()))()()()()(()))()()"));
    }
}
