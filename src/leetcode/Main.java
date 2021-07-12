package leetcode;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] temp = new int[][]{
                {1, 2},
                {1, 2},
                {1, 2},
                {1, 2}
        };
        int[][] temp2 = new int[][]{
                {1, 2},
                {2, 3},
                {3, 4},
                {1, 3}
        };

//        sol.commitForRestDay(2020);
//        System.out.println(sol.findLengthOfLCIS(new int[]{1, 3, 5, 4, 7}));
//        System.out.println(sol.findLengthOfLCIS(new int[]{1, 3, 5, 7}));

//        MedianFinder m = new MedianFinder();
//        m.addNum(1);
//        m.addNum(2);
//        System.out.println(m.findMedian());
//        m.addNum(3);
//        System.out.println(m.findMedian());

        System.out.println(sol.eraseOverlapIntervals(temp));
        System.out.println(sol.eraseOverlapIntervals(temp2));
    }
}
