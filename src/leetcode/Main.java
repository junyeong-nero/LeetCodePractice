package leetcode;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.searchRange(new int[]{2, 2}, 2)));
        System.out.println(Arrays.toString(sol.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
        System.out.println(Arrays.toString(sol.searchRange(new int[]{5, 7, 7, 8, 8, 9, 10}, 8)));
        System.out.println(Arrays.toString(sol.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6)));
        System.out.println(Arrays.toString(sol.searchRange(new int[]{}, 0)));
    }

}
