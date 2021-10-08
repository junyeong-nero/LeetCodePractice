package leetcode;

import DataStructure.MyQueue;
import DataStructure.MyQueueByStack;
import DataStructure.MyStack;

import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Solution sol = new Solution();
        // 0,1],[0,2],[2,3],[2,4],[2,5
        int[][] arr = new int[][]{
                {0, 0, 0},
                {1, 1, 0},
                {0, 0, 0},
                {0, 1, 1},
                {0, 0, 0}
        };

        int[][] arr2 = new int[][]{
                {0, 1, 1},
                {1, 1, 1},
                {1, 0, 0},
        };

        int[][] arr3 = new int[][]{
                {0, 1, 0, 1},
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {1, 0, 0, 1},
                {0, 1, 0, 0}
        };

        int[] a = new int[]{
                -1, 1, 0
        };

        System.out.println(sol.uniquePaths(23, 12));

    }
}
