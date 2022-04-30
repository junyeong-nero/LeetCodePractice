package leetcode;

import java.util.ArrayList;
import java.util.PriorityQueue;

class MedianFinder {

    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;

    /** initialize your data structure here. */
    public MedianFinder() {
        min = new PriorityQueue<>((a, b) -> a - b);
        max = new PriorityQueue<>((a, b) -> b - a);
    }

    public void addNum(int num) {
        if (max.size() > 0 && num >= max.peek()) {
            min.add(num);
        } else {
            max.add(num);
        }

        PriorityQueue<Integer> s;
        PriorityQueue<Integer> b;
        if (min.size() > max.size()) {
            s = max;
            b = min;
        } else {
            s = min;
            b = max;
        }
        while (Math.abs(b.size() - s.size()) > 1) {
            s.add(b.remove());
        }
    }

    public double findMedian() {
        if (min.size() == max.size()) {
            if (min.size() == 0) {
                return 0;
            }
            return (min.peek() + max.peek()) / 2.0f;
        }

        if (min.size() > max.size()) {
            return (double)min.peek();
        } else {
            return (double)max.peek();
        }
    }
}
