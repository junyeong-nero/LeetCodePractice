package leetcode;

import DataStructure.MyQueue;
import DataStructure.MyStack;

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
        MyStack myStack = new MyStack(10);
        for (int i = 1; i <= 10; i++) {
            myQueue.push(i);
            myStack.push(i);
        }
        System.out.println("Queue");
        System.out.println(myQueue);
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        System.out.println(myQueue);

        System.out.println("Stack");
        System.out.println(myStack);
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack);

    }
}
