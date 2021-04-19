package leetcode;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
//        System.out.println("sol : " + sol.isValid("("));
        System.out.println("sol1 : " + sol.removeDuplicates(arr));
    }

}
