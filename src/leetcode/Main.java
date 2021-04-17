package leetcode;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Solution sol = new Solution();
//        System.out.println("sol : " + sol.isValid("("));
        System.out.println("sol : " + sol.isValid2("()"));
        System.out.println("sol : " + sol.isValid2("()[]{}"));
        System.out.println("sol : " + sol.isValid2("(]"));
        System.out.println("sol : " + sol.isValid2("([)]"));
        System.out.println("sol : " + sol.isValid2("{[()]}("));
        System.out.println("sol : " + sol.isValid2("{}{}()[]"));
    }

}
