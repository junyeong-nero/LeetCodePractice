package DataStructure;

public class MyQueueByStack {

	int size = 0;
	MyStack L, R;

	public MyQueueByStack(int capacity) {
		int size = capacity;
		this.L = new MyStack(capacity);
		this.R = new MyStack(capacity);
	}

	public void push(int element) {
		R.push(element);
	}

	public int top() {
		front();
		return L.top();
	}

	public int pop() {
		front();
		return L.pop();
	}

	private void front() {
		if (L.isEmpty()) {
			while (!R.isEmpty()) {
				L.push(R.pop());
			}
		}
	}

	public boolean isFull() {
		return size == L.size + R.size;
	}

	public boolean isEmpty() {
		return L.size + R.size == 0;
	}

	public String toString() {
		return "Left : " + L.toString() +
				"\nRight : " + R.toString();
	}
}
