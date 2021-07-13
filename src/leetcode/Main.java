package leetcode;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Solution sol = new Solution();
//        System.out.println(sol.isIsomorphic("add", "egg"));
//        System.out.println(sol.isIsomorphic("foo", "bar"));
        System.out.println(sol.backspaceCompare("ab#c", "ad#c"));
        System.out.println(sol.backspaceCompare("ab##", "c#d#"));
        System.out.println(sol.backspaceCompare("a##c", "#a#c"));
        System.out.println(sol.backspaceCompare("a#c", "b"));
    }
}
