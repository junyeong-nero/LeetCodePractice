package leetcode;

import DataStructure.ListNode;
import DataStructure.MyStack;
import DataStructure.TreeNode;
import com.sun.source.tree.Tree;

import java.util.*;

public class Solution {

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