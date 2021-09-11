package leetcode;

import java.util.ArrayList;

public class MyQueue {
	ArrayList<Integer> arr = new ArrayList<>();
	int size = 0;
	int front = 0;
	int rear = 0;

	public MyQueue(int capacity) {
		this.size = capacity + 1;
		for (int i = 0; i <= size; i++) arr.add(0);
	}

	public int get(int index) {
		return arr.get((front + 1 + index) % size);
	}

	public int pop() {
		int res = this.get(0);
		front++;
		arr.set(front, 0);
		return res;
	}

	public void push(int num) {
		rear++;
		arr.set(rear, num);
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (int i = front + 1; i <= rear; i++) builder.append(arr.get(i % size)).append(" ");
		return builder.toString();
	}
}
