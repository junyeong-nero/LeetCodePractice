package leetcode;

import DataStructure.ListNode;
import DataStructure.MyStack;
import DataStructure.TreeNode;
import com.sun.source.tree.Tree;

import java.util.*;

public class Solution {

	ListNode node;
	int len;

	public Solution(ListNode head) {
		node = head;
		len = size(node);
	}

	public int size(ListNode n) {
		if(n == null) return 0;
		return 1 + size(n.next);
	}

	public int getRandom() {
		ListNode temp = node;
		int num = (int) (Math.random() * len);
		for (int i = 0; i < num; i++)
			temp = temp.next;
		return temp.val;
	}

	public int guess (int n) {
		if (n == 3) return 0;
		else if (n > 3) return 1;
		else return 1;
	}

	public int guessNumber(int n) {
		int i = 1, j = n;
		while(i < j) {
			int mid = i + (j - i) / 2;
			if(guess(mid) == 0) {
				return mid;
			} else if(guess(mid) == 1) {
				i = mid + 1;
			} else {
				j = mid;
			}
		}
		return i;
	}
}