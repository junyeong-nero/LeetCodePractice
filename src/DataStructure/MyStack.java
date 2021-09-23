package DataStructure;

import java.util.ArrayList;

public class MyStack {
	int lastIndex = -1;
	int size = 0;
	int[] arr;

	public MyStack(int capacity) {
		this.arr = new int[capacity];
		this.size = capacity;
	}

	public boolean isEmpty() {
		return lastIndex == -1;
	}

	public boolean isFull() {
		return lastIndex == size;
	}

	public void push(int data) {
		arr[++lastIndex] = data;
	}

	public int get(int index) {
		return arr[index];
	}

	public int pop() {
		return arr[lastIndex--];
	}

	public int top() {
		return arr[lastIndex];
	}


	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i <= lastIndex; i++) builder.append(arr[i]).append(" ");
		return builder.toString();
	}
}
