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
        Solution solution = new Solution(new ListNode(1, new ListNode(2, new ListNode(3))));
        solution.getRandom(); // return 1
        solution.getRandom(); // return 3
        solution.getRandom(); // return 2
        solution.getRandom(); // return 2
        solution.getRandom(); // return 3
    }
}
