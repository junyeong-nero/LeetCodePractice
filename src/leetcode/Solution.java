package leetcode;

import DataStructure.ListNode;
import DataStructure.MyStack;
import DataStructure.TreeNode;
import com.sun.source.tree.Tree;

import java.util.*;

public class Solution {

	ListNode node;
	int len;

	public Solution() {

	}

	// 773. Sliding Puzzle
	public int slidingPuzzle(int[][] board) {
		int[] temp = new int[2];
		int res = 0;

		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i][j] == 0) {
					temp[0] = i;
					temp[1] = j;
				}
			}
		}

		int[] posX = new int[]{0, 1, 0, -1};
		int[] posY = new int[]{1, 0, -1, 0};
		for (int i = 0; i < 4; i++) {
			if (check(board))
				return res;
			int x = temp[0] + posX[i];
			int y = temp[0] + posY[i];
			if (x < 0 || x >= 2 || y < 0 || y >= 3)
				continue;
			int tmp = board[x][y];
		}
		return res;
	}

	public boolean check(int[][] board) {
		return board[0][0] == 1 && board[0][1] == 2 && board[0][2] == 3 &&
				board[1][0] == 4 && board[1][1] == 5;
	}


}