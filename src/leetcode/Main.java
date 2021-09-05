package leetcode;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Solution sol = new Solution();
        // 0,1],[0,2],[2,3],[2,4],[2,5
        int[][] arr = new int[][]{
                {0, 1}, {0, 2}, {2, 3}, {2, 4}, {2, 5}
        };
        System.out.println(Arrays.toString(sol.sumOfDistancesInTree(6, arr)));
    }
}
