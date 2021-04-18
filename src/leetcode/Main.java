package leetcode;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Solution sol = new Solution();
//        System.out.println("sol : " + sol.isValid("("));
        System.out.println("sol1 : " + sol.generateParenthesis(1));
        System.out.println("sol2 : " + sol.generateParenthesis(2));
        System.out.println("sol4 : " + sol.generateParenthesis(4));
        System.out.println("sol8 : " + sol.generateParenthesis(8));

    }

}
