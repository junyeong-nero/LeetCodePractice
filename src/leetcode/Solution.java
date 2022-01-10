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
		String target = "123450";
		String start = "";
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				start += board[i][j];
			}
		}
		HashSet<String> visited = new HashSet<>();
		// all the positions 0 can be swapped to
		int[][] dirs = new int[][] { { 1, 3 }, { 0, 2, 4 },
				{ 1, 5 }, { 0, 4 }, { 1, 3, 5 }, { 2, 4 } };
		Queue<String> queue = new LinkedList<>();
		queue.offer(start);
		visited.add(start);
		int res = 0;
		while (!queue.isEmpty()) {
			// level count, has to use size control here, otherwise not needed
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				String cur = queue.poll();
				if (cur.equals(target)) {
					return res;
				}
				int zero = cur.indexOf('0');
				// swap if possible
				for (int dir : dirs[zero]) {
					String next = swap(cur, zero, dir);
					if (visited.contains(next)) {
						continue;
					}
					visited.add(next);
					queue.offer(next);

				}
			}
			res++;
		}
		return -1;
	}

	private String swap(String str, int i, int j) {
		StringBuilder sb = new StringBuilder(str);
		sb.setCharAt(i, str.charAt(j));
		sb.setCharAt(j, str.charAt(i));
		return sb.toString();
	}

	public int MyslidingPuzzle(int[][] board) {
		int[] temp = new int[2];
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i][j] == 0) {
					temp[0] = i;
					temp[1] = j;
				}
			}
		}
		if (check(board))
			return 0;

		return slidingPuzzleDFS(board, temp, -1);
	}

	public int slidingPuzzleDFS(int[][] board, int[] pos, int dir) {
		int res = Integer.MAX_VALUE;
		if (check(board))
			return 0;
		
		int[] posX = new int[]{0, 1, 0, -1};
		int[] posY = new int[]{1, 0, -1, 0};
		for (int i = 1; i <= 4; i++) {
			int new_dir = (dir + i) % 4;
			int[] new_pos = new int[] {
					pos[0] + posX[new_dir],
					pos[1] + posY[new_dir]
			};
			int x = new_pos[0];
			int y = new_pos[1];
			if (x < 0 || x >= 2 || y < 0 || y >= 3)
				continue;
			if (x == pos[0] && y == pos[1])
				continue;
			int b = board[x][y];
			board[x][y] = 0;
			board[pos[0]][pos[1]] = b;
			System.out.println(Arrays.deepToString(board));
			res = Math.min(res, slidingPuzzleDFS(board, new_pos, new_dir));
			board[x][y] = b;
			board[pos[0]][pos[1]] = 0;
		}
		return res + 1;
	}

	public boolean check(int[][] board) {
		return board[0][0] == 1 && board[0][1] == 2 && board[0][2] == 3 &&
				board[1][0] == 4 && board[1][1] == 5;
	}


}