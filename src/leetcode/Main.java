package leetcode;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = new int[]{3, 9, 7, 1, 2, 3};
        int[] arr2 = new int[]{1, 2, 3, 6, 8, 9 };
        System.out.println(Arrays.deepToString(sol.outerTrees(new int[][]{
                {1, 1}, {2, 2}, {2, 0}, {2, 4}, {3, 3}, {4, 2}
        })));

    }
}
