package leetcode;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] arr = new int[][]{
                {0, 0, 2, 2}, {1, 0, 2, 3}, {1, 0, 3, 1}
        };
        System.out.println(sol.combinationSum3(new int[]{2, 3, 5, 7}, 7));
    }
}
