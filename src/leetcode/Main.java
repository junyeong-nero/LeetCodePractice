package leetcode;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Solution sol = new Solution();
        // 0,1],[0,2],[2,3],[2,4],[2,5
        int[][] arr = new int[][]{
                {0, 1}, {0, 2}, {2, 3}, {2, 4}, {2, 5}
        };
        int[] a = new int[]{
                -1, 1, 0
        };
        MyQueue myQueue = new MyQueue(10);
        for (int i = 1; i <= 10; i++) {
            myQueue.push(i);
        }
        System.out.println(myQueue);
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());

    }
}
