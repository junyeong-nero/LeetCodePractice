package leetcode;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] img1 = new int[][]{
                {1, 1, 0},
                {0, 1, 0},
                {0, 1, 0}
        };

        int[][] img2 = new int[][]{
                {0, 0, 0},
                {0, 1, 1},
                {0, 0, 1}
        };
//        System.out.println(sol.largestOverlap(img1, img2));
        System.out.println(Arrays.toString(sol.beautifulArray(4)));
        System.out.println(Arrays.toString(sol.beautifulArray(5)));
        System.out.println(Arrays.toString(sol.beautifulArray(6)));
        System.out.println(Arrays.toString(sol.beautifulArray(7)));
        System.out.println(Arrays.toString(sol.beautifulArray(8)));
//        System.out.println(sol.partitionDisjoint(new int[]{5, 0, 3, 8, 6}));
//        System.out.println(sol.partitionDisjoint(new int[]{1, 1, 1, 0, 6, 12}));
    }
}
