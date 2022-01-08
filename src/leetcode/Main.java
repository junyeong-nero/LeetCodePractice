package leetcode;

import DataStructure.ListNode;
import DataStructure.MyQueue;
import DataStructure.MyQueueByStack;
import DataStructure.MyStack;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.print(sol.slidingPuzzle(new int[][]{
                {4, 1, 2},
                {5, 0, 3}
        }));

    }
}
