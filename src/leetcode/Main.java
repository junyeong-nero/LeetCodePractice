package leetcode;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.partitionDisjoint(new int[]{5, 0, 3, 8, 6}));
        System.out.println(sol.partitionDisjoint(new int[]{1, 1, 1, 0, 6, 12}));
    }
}
