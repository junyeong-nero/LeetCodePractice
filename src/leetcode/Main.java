package leetcode;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] tmp = new int[][]{
                {2, 1, 3},
                {6, 5, 4},
                {7, 8, 9}
        };

        int[][] temp = new int[][]{{-48}};
        System.out.println(sol.subtractProductAndSum(234));
        System.out.println(sol.subtractProductAndSum(4421));
    }
}
