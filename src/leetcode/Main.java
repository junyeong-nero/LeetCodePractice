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
                {0, 1}, {0, 2}, {2, 3}, {2, 4}, {2, 5}
        };
        int[] a = new int[]{
                -1, 1, 0
        };

        System.out.println(sol.maxLength(List.of("cha", "r", "act", "ers")));
        System.out.println(sol.maxLength(List.of("abcdefghijklmnopqrstuvwxyz")));
        System.out.println(sol.maxLength(List.of("a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p")));

//        MyQueue myQueue = new MyQueue(10);
//        MyQueueByStack myQueueByStack = new MyQueueByStack(10);
//        MyStack myStack = new MyStack(10);
//        for (int i = 1; i <= 10; i++) {
//            myQueue.push(i);
//            myStack.push(i);
//            myQueueByStack.push(i);
//        }
//
//        System.out.println("\nQueue");
//        System.out.println(myQueue);
//        System.out.println(myQueue.pop());
//        System.out.println(myQueue.pop());
//        System.out.println(myQueue.pop());
//        System.out.println(myQueue);
//
//        System.out.println("\nQueueByStack");
//        System.out.println(myQueueByStack);
//        System.out.println(myQueueByStack.pop());
//        System.out.println(myQueueByStack.pop());
//        System.out.println(myQueueByStack.pop());
//        System.out.println(myQueueByStack);
//
//        System.out.println("\nStack");
//        System.out.println(myStack);
//        System.out.println(myStack.pop());
//        System.out.println(myStack.pop());
//        System.out.println(myStack.pop());
//        System.out.println(myStack);

    }
}
