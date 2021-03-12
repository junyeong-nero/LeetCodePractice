package leetcode;

import java.util.Arrays;

public class Main {

    public static void test(int input, String result) {
        Solution sol = new Solution();
        String s = sol.intToRoman(input);
        System.out.println(s + " : " + result);
    }

    public static void main(String[] args) {
        test(3, "III");
        test(4, "IV");
        test(58, "LVIII");
        test(1994, "MCMXCIV");
        test(3999, "MMMCMXCIX");
    }
}
