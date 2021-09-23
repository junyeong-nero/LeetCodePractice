package DataStructure;

public class MyQueue {
	int[] arr;
	int size;
	int front = 0;
	int rear = 0;
	int curSize = 0;

	public MyQueue(int capacity) {
		this.size = capacity + 1;
		this.arr = new int[capacity + 2];
		for (int i = 0; i <= size; i++) arr[i] = 0;
	}

	public boolean isEmpty() {
		return curSize == 0;
	}

	public boolean isFull() {
		return curSize == size;
	}

	public int get(int index) {
		return arr[(front + 1 + index) % size];
	}

	public int pop() {
		int res = this.get(0);
		front++;
		curSize--;
		arr[front] = 0;
		return res;
	}

	public int top() {
		return this.get(0);
	}

	public void push(int num) {
		rear++;
		curSize++;
		arr[rear] = num;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (int i = front + 1; i <= rear; i++) builder.append(arr[i % size]).append(" ");
		return builder.toString();
	}
}
