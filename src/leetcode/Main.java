package leetcode;

import DataStructure.MyQueue;
import DataStructure.MyQueueByStack;
import DataStructure.MyStack;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Solution sol = new Solution();
        // 0,1],[0,2],[2,3],[2,4],[2,5
        int[][] arr = new int[][]{
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18}
        };

        int[] a = new int[]{
                -1, 1, 0
        };

        System.out.println(Arrays.deepToString(sol.merge(arr)));

    }
}
